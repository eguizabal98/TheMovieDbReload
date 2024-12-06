package com.eem.navigation.core

import androidx.navigation.NamedNavArgument

interface NavigationRoute {
    val route: String
    val arguments: List<NamedNavArgument> get() = emptyList()
}
