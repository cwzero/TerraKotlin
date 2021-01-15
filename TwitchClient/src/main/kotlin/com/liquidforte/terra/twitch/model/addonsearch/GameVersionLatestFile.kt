package com.liquidforte.terra.twitch.model.addonsearch

data class GameVersionLatestFile(
    val gameVersion: String,
    val projectFileId: Long,
    val projectFileName: String,
    val fileType: Long,
)
