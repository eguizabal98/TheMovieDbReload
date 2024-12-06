package com.eem.navigation.core

interface NavigationCommand {
    val destination: String get() = ""
    val popUpTo: String get() = ""
}
