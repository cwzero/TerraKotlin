package com.liquidforte.terra.twitch.model.file

data class FileDependency(
    val id: Long,
    val addonId: Long,
    val type: Long,
    val fileId: Long
)
