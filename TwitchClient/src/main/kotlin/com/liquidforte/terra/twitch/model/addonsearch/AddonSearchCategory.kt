package com.liquidforte.terra.twitch.model.addonsearch

data class AddonSearchCategory(
    val categoryId: Long,
    val name: String,
    val url: String,
    val avatarUrl: String,
    val parentId: Long,
    val rootId: Long,
    val projectId: Long,
    val avatarId: Long,
    val gameId: Long
)
