package com.turkurt656.buildsrc.modules

object CommonModules {

    object Paths {
        const val common = "common"

        const val core = "core"
    }

    val core = module(Paths.common, Paths.core)

}