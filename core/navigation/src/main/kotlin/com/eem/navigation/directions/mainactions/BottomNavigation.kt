package com.eem.navigation.directions.mainactions

import com.eem.navigation.core.NavigationCommand

data class BottomNavigation(
    val navigationCommand: NavigationCommand,
    override val popUpTo: String = "",
) : NavigationCommand {
    override val destination: String
        get() = navigationCommand.destination
}
