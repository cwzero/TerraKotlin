package com.liquidforte.terra.model

import java.util.*

data class Author(
    val name: String
) {
    val id: Optional<Long> = Optional.empty()
}
