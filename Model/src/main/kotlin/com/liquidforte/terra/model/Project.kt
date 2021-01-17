package com.liquidforte.terra.model

import java.util.*

interface Project {
    val id: Optional<Long>
    val name: String
    val authors: MutableSet<Author>
}