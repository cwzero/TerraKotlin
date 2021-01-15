package com.liquidforte.terra.twitch.model.fingerprint

import com.liquidforte.terra.twitch.model.latestfile.LatestFile

data class FingerprintMatch(
    val id: Long,
    val file: LatestFile
) {
    val latestFiles: MutableList<LatestFile> = mutableListOf()
}
