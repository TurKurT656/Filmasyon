package com.turkurt656.library.navigation.ktx

import androidx.navigation.NavController
import java.lang.Exception

inline fun NavController.doSafely(block: NavController.() -> Unit) =
    try {
        block()
    } catch (e: Exception) {
        // Add Logger here to catch failed navigation
        e.printStackTrace()
    }