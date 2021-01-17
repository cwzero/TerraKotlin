package com.liquidforte.terra.twitch.model.fingerprint

import com.liquidforte.terra.twitch.model.file.File

data class FingerprintMatch(
    val id: Long,
    val file: File
) {
    val files: MutableList<File> = mutableListOf()
}
