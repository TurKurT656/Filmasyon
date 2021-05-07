package com.turkurt656.buildsrc.modules

object LibraryModules {

    object Paths {
        const val library = "library"

        const val core = "core"
        const val lifecycle = "lifecycle"
        const val designSystem = "designsystem"
        const val action = "action"
        const val navigation = "navigation"
        const val imageLoader = "imageloader"

    }

    val core = module(Paths.library, Paths.core)
    val lifecycle = module(Paths.library, Paths.lifecycle)
    val designSystem = module(Paths.library, Paths.designSystem)
    val action = module(Paths.library, Paths.action)
    val navigation = module(Paths.library, Paths.navigation)
    val imageLoader = module(Paths.library, Paths.imageLoader)

}