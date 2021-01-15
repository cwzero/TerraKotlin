package com.liquidforte.terra.twitch.model.latestfile

data class LatestFileDependency(
    val id: Long,
    val addonId: Long,
    val type: Long,
    val fileId: Long
)
