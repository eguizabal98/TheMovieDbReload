package com.eem.navigation.manager

import com.eem.navigation.core.NavigationCommand
import com.eem.navigation.core.NavigationManager
import com.eem.navigation.directions.mainactions.BottomNavigation
import com.eem.navigation.directions.mainactions.NavigateWithPopUpTo
import com.eem.navigation.directions.mainactions.PopBackStack
import com.eem.navigation.directions.mainactions.PopBackStackWithResult
import com.eem.navigation.directions.mainactions.PopBackToNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

internal class NavigationManagerImpl : NavigationManager {
    private val scope = CoroutineScope(Dispatchers.Main)
    private val _commands = MutableSharedFlow<NavigationCommand>()
    override val commands: SharedFlow<NavigationCommand> = _commands

    override fun navigate(direction: NavigationCommand) {
        emitCommand(direction)
    }

    override fun popBackStack() {
        emitCommand(PopBackStack)
    }

    override fun popBackStackWithResult(resultKey: String, result: Any) {
        emitCommand(PopBackStackWithResult(resultKey, result))
    }

    override fun navigateWithPopUpTo(direction: NavigationCommand, popUpTo: String) {
        emitCommand(NavigateWithPopUpTo(direction, popUpTo))
    }

    override fun bottomNavigation(direction: NavigationCommand, popUpTo: String) {
        emitCommand(BottomNavigation(direction, popUpTo))
    }

    override fun popUpTo(direction: NavigationCommand, inclusive: Boolean) {
        emitCommand(PopBackToNavigation(direction, inclusive))
    }

    private fun emitCommand(command: NavigationCommand) {
        scope.launch {
            _commands.emit(command)
        }
    }
}
