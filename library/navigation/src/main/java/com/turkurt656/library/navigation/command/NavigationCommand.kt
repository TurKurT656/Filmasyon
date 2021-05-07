package com.turkurt656.library.navigation.command

sealed class NavigationCommand {
    data class To(val flow: NavigationFlow) : NavigationCommand()
    object Back : NavigationCommand()
    data class BackTo(val destinationId: Int, val inclusive: Boolean) : NavigationCommand()
}