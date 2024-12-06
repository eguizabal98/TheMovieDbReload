package com.eem.navigation.directions.mainactions

import com.eem.navigation.core.NavigationCommand

data class PopBackToNavigation(
    val navCommand: NavigationCommand,
    val inclusive: Boolean,
) : NavigationCommand {
    override val destination: String
        get() = navCommand.destination
}
