package com.eem.navigation.core

import kotlinx.coroutines.flow.Flow

interface NavigationManager {
    val commands: Flow<NavigationCommand>

    fun navigate(direction: NavigationCommand)

    fun popBackStack()

    fun popBackStackWithResult(resultKey: String, result: Any)

    fun navigateWithPopUpTo(direction: NavigationCommand, popUpTo: String)

    fun bottomNavigation(direction: NavigationCommand, popUpTo: String = "")

    fun popUpTo(direction: NavigationCommand, inclusive: Boolean = false)
}