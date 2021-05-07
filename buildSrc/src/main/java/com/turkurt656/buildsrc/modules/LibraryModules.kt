package com.turkurt656.buildsrc.modules

object LibraryModules {

    object Paths {
        const val library = "library"

        const val core = "core"
        const val lifecycle = "lifecycle"
        const val designSystem = "designsystem"

    }

    val core = module(Paths.library, Paths.core)
    val lifecycle = module(Paths.library, Paths.lifecycle)
    val designSystem = module(Paths.library, Paths.designSystem)

}