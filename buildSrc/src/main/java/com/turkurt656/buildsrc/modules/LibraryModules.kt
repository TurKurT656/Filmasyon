package com.turkurt656.buildsrc.modules

object LibraryModules {

    object Paths {
        const val library = "library"

        const val core = "core"
        const val lifecycle = "lifecycle"

    }

    val core = module(Paths.library, Paths.core)
    val lifecycle = module(Paths.library, Paths.lifecycle)

}