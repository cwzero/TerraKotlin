package com.liquidforte.terra.twitch.model.addonsearch

data class AddonAuthor(
    val id: Long,
    val name: String,
    val url: String,
    val projectId: Long,
    val userId: Long,
    val twitchId: Long
)