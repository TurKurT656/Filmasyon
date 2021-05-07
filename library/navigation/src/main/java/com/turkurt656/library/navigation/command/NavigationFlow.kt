package com.turkurt656.library.navigation.command

import androidx.navigation.NavDirections

sealed class NavigationFlow {
    //object ToX : NavigationFlow()
}


fun NavigationFlow.toNavDirections(): NavDirections =
    TODO()
//    when(this) {
//        is NavigationFlow.ToX -> ActionOnlyNavDirections(0)
//    }