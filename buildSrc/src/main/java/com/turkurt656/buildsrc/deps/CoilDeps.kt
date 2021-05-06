package com.turkurt656.buildsrc.deps

object CoilDeps {

    object Versions {
        const val coil = "1.1.1"
    }

    val coilBase = dependency("io.coil-kt:coil-base", Versions.coil)
    val coil = dependency("io.coil-kt:coil", Versions.coil)

}