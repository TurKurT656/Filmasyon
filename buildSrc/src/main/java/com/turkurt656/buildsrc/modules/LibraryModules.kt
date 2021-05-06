package com.turkurt656.buildsrc.modules

object LibraryModules {

    object Paths {
        const val library = "library"

        const val core = "core"

    }

    val core = module(Paths.library, Paths.core)

}