package com.liquidforte.terra.model

import java.util.*

data class Pack(
    override val name: String,
    override val authors: MutableSet<Author> = mutableSetOf()
) : Project {
    override val id: Optional<Long> = Optional.empty()
}
