package com.eem.navigation.directions.screens

import com.eem.navigation.core.NavigationCommand
import com.eem.navigation.core.NavigationRoute
import com.eem.navigation.directions.NavigationScreens

object OnBoardNavigation : NavigationRoute, NavigationCommand {
    override val route = NavigationScreens.ONBOARD.route
    override val destination: String = route
}
