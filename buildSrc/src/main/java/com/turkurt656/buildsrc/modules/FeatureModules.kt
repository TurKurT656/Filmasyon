package com.turkurt656.buildsrc.modules

object FeatureModules {

    object Paths {
        const val feature = "feature"

        const val splash = "splash"
        const val tvShow = "tvshow"

    }

    val splash = module(Paths.feature, Paths.splash)
    val tvShow = module(Paths.feature, Paths.tvShow)

}