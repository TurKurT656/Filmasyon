package com.turkurt656.common.core.ktx

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.library.action.command.actBy
import com.turkurt656.library.navigation.command.navigateBy

fun LifecycleOwner.addNavigatorOn(
    viewModel: BaseViewModel,
    navController: NavController
) {
    viewModel.navigationCommand.observe(this) { command ->
        navController.navigateBy(command)
    }
}

fun LifecycleOwner.observeActions(
    viewModel: BaseViewModel
) {
    viewModel.actionCommand.observe(this) { command ->
        actBy(command)
    }
}

val View.lifecycleOwner: LifecycleOwner?
    get() = try {
        val fragment = findFragment<Fragment>()
        fragment.viewLifecycleOwner
    } catch (e: IllegalStateException) {
        when (val activity = context.getActivity()) {
            is ComponentActivity -> activity
            else -> null
        }
    }

private tailrec fun Context.getActivity(): Activity? = this as? Activity
    ?: (this as? ContextWrapper)?.baseContext?.getActivity()
