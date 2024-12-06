package com.eem.navigation.manager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.eem.navigation.core.NavigationManager
import com.eem.navigation.directions.mainactions.BottomNavigation
import com.eem.navigation.directions.mainactions.NavigateUp
import com.eem.navigation.directions.mainactions.NavigateWithPopUpTo
import com.eem.navigation.directions.mainactions.PopBackStack
import com.eem.navigation.directions.mainactions.PopBackStackWithResult
import com.eem.navigation.directions.mainactions.PopBackToNavigation
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun HandleNavigationCommands(
    navigationManager: NavigationManager,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        navigationManager.commands
            .onEach { command ->
                when (command) {
                    NavigateUp -> navController.navigateUp()
                    PopBackStack -> navController.popBackStack()

                    is PopBackStackWithResult -> {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            command.resultKey,
                            command.result
                        )
                        navController.popBackStack()
                    }

                    is NavigateWithPopUpTo -> {
                        navController.navigate(command.destination) {
                            popUpTo(command.popUpTo) {
                                inclusive = true
                            }
                        }
                    }

                    is BottomNavigation -> {
                        // Send a pop up to destination to clear the back stack and reload the bottom navigation screen
                        // For more info see: https://issuetracker.google.com/issues/294408574
                        if (command.popUpTo.isNotBlank()) {
                            navController.clearBackStack(command.popUpTo)
                        }
                        if (navController.currentDestination != null) {
                            navController.navigate(command.destination) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // re-selecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    }

                    is PopBackToNavigation -> {
                        navController.popBackStack(command.destination, command.inclusive)
                    }

                    else -> {
                        navController.navigate(command.destination)
                    }
                }
            }
            .launchIn(this)
    }
}

