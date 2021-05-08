package com.turkurt656.common.core.ba

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

object TextViewBindingAdapter {

    @BindingAdapter("binding:textRes")
    @JvmStatic
    fun setTextRes(textView: TextView, @StringRes resId: Int?) {
        resId?.let { textView.text = textView.context.getString(it) }
    }

    @BindingAdapter("binding:select")
    @JvmStatic
    fun selectTextView(textView: TextView, isSelected: Boolean?) {
        textView.isSelected = isSelected == true
    }

}