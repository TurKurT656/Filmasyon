package com.turkurt656.library.designsystem.ktx

import android.content.res.Resources

val Float.toPx
    get() = this * Resources.getSystem().displayMetrics.density

val Int.toPx
    get() = toFloat().toPx.toInt()

val Float.toDp
    get() = this / Resources.getSystem().displayMetrics.density

val Int.toDp
    get() = toFloat().toDp.toInt()