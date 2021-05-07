package com.turkurt656.library.navigation.command

import androidx.navigation.NavController
import com.turkurt656.library.navigation.ktx.doSafely

fun NavController.navigateBy(command: NavigationCommand) {
    when (command) {
        is NavigationCommand.To ->
            doSafely { navigate(command.flow.toNavDirections()) }
        is NavigationCommand.Back ->
            doSafely { popBackStack() }
        is NavigationCommand.BackTo ->
            doSafely { popBackStack(command.destinationId, command.inclusive) }
    }
}