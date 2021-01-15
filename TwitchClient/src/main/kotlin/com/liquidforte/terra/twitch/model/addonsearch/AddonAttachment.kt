package com.liquidforte.terra.twitch.model.addonsearch

data class AddonAttachment(
    val id: Long,
    val projectId: Long,
    val description: String,
    val isDefault: Boolean,
    val thumbnailUrl: String,
    val title: String,
    val url: String,
    val status: Long
)
