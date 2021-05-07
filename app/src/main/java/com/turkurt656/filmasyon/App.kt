package com.turkurt656.filmasyon

import androidx.multidex.MultiDexApplication
import com.turkurt656.library.imageloader.ImageLoader
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import java.util.*

@KoinApiExtension
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // Init Koin
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }

        ImageLoader.init()
    }

}