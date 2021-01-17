package com.liquidforte.terra.model

import java.util.*

data class Mod(
    var slug: String = ""
) : Project {
    override val name: String
        get() = slug
    override val authors: MutableSet<Author> = mutableSetOf()
    override var id: Optional<Long> = Optional.empty()
    var curseForgeId: Optional<Long> = Optional.empty()
}