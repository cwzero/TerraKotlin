package com.liquidforte.terra.model

import java.util.*

data class PackVersion(
    val pack: Pack,
    val version: String,
    val modVersion: MutableSet<ModVersion> = mutableSetOf()
) {
    val id: Optional<Long> = Optional.empty()
}
