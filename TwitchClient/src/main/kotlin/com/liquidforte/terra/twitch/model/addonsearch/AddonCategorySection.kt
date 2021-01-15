package com.liquidforte.terra.twitch.model.addonsearch

data class AddonCategorySection(
    val id: Long,
    val gameId: Long,
    val name: String,
    val packageType: Long,
    val path: String,
    val initialInclusionPattern: String,
    val gameCategoryId: Long
)