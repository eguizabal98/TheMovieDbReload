package com.eem.navigation.directions.mainactions

import com.eem.navigation.core.NavigationCommand

data class NavigateWithPopUpTo(val navCommand: NavigationCommand, override val popUpTo: String) :
    NavigationCommand {
    override val destination: String
        get() = navCommand.destination
}
