package com.turkurt656.library.imageloader.logger

import android.util.Log
import coil.util.Logger

internal class CoilLogger : Logger {

    override var level: Int = Log.DEBUG

    override fun log(tag: String, priority: Int, message: String?, throwable: Throwable?) {
        Log.d(tag, message, throwable)
    }
}