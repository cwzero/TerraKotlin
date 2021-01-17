package com.liquidforte.terra.model

import java.util.*

data class File (
    val displayName: String,
    val fileName: String,
    val fileDate: Date,
    val fileLength: Long,
    val downloadUrl: String
) {
    var id: Optional<Long> = Optional.empty()
    var curseForgeId: Optional<Long> = Optional.empty()
}