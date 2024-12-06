package com.eem.navigation.directions.mainactions

import com.eem.navigation.core.NavigationCommand

data class PopBackStackWithResult(val resultKey: String, val result: Any) : NavigationCommand {
    override val destination: String = "popBackStackWithResult"
}
