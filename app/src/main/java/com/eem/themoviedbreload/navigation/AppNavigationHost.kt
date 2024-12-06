package com.eem.themoviedbreload.navigation

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eem.navigation.directions.screens.OnBoardNavigation
import com.eem.themoviedbreload.OnBoardScreen

@Composable
fun AppNavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showSnackBar: (message: String, withDismissAction: Boolean, duration: SnackbarDuration) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = OnBoardNavigation.destination
    ) {
        composable(OnBoardNavigation.route) {
            OnBoardScreen()
        }
    }
}
