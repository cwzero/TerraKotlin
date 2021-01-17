package com.liquidforte.terra.model

import java.util.*

data class ModVersion(
    val mod: Mod,
    val file: File
) {
    val id: Optional<Long> = Optional.empty()
}
