package com.turkurt656.common.core.ba

import android.view.View
import androidx.databinding.BindingAdapter
import com.turkurt656.data.domain.result.Result
import com.turkurt656.library.designsystem.ktx.hide
import com.turkurt656.library.designsystem.ktx.show

object ViewBindingAdapter {

    @BindingAdapter(
        "binding:enabled",
        "binding:enabledOnLoading",
        "binding:enabledOnSuccess",
        "binding:enabledOnError",
        "binding:enabledOnNull",
        requireAll = false,
    )
    @JvmStatic
    fun <T> isEnabled(
        view: View,
        result: Result<T>?,
        enabledOnLoading: Boolean?, // Default is false
        enabledOnSuccess: Boolean?, // Default is true
        enabledOnError: Boolean?, // Default is true
        enabledOnNull: Boolean?, // Default is true
    ) {
        view.isEnabled = when (result) {
            is Result.Loading -> enabledOnLoading ?: false
            is Result.Success -> enabledOnSuccess ?: true
            is Result.Error -> enabledOnError ?: true
            else -> enabledOnNull ?: true
        }
    }

    @BindingAdapter(
        "binding:visibility",
        "binding:isGone",
        requireAll = false,
    )
    @JvmStatic
    fun isVisible(
        view: View,
        isVisible: Boolean?, // Default is false
        isGone: Boolean?, // Default is true
    ) {
        if (isVisible == true) view.show()
        else view.hide(isGone ?: true)
    }

    @BindingAdapter(
        "binding:visibility",
        "binding:isGone",
        "binding:visibilityOnLoading",
        "binding:visibilityOnSuccess",
        "binding:visibilityOnError",
        "binding:visibilityOnNull",
        requireAll = false,
    )
    @JvmStatic
    fun <T> isVisible(
        view: View,
        result: Result<T>?,
        isGone: Boolean?, // Default is true
        visibilityOnLoading: Boolean?, // Default is false
        visibilityOnSuccess: Boolean?, // Default is true
        visibilityOnError: Boolean?, // Default is true
        visibilityOnNull: Boolean?, // Default is false
    ) {
        val gone = isGone ?: true
        when (result) {
            is Result.Loading -> if (visibilityOnLoading == true) view.show() else view.hide(gone)
            is Result.Success -> if (visibilityOnSuccess != false) view.show() else view.hide(gone)
            is Result.Error -> if (visibilityOnError != false) view.show() else view.hide(gone)
            else -> if (visibilityOnNull == true) view.show() else view.hide(gone)
        }
    }

}