package com.liquidforte.terra.twitch.model.addonsearch

import com.liquidforte.terra.twitch.config.TwitchConfig

data class AddonSearchRequest(
    val categoryId: Long,
    val gameId: Long,
    val gameVersion: String,
    val index: Long,
    val pageSize: Long,
    val searchFilter: String,
    val sectionId: Long,
    val sort: Long
) {
    constructor(config: TwitchConfig, categoryId: Long, index: Long, searchFilter: String, sectionId: Long) : this(
        categoryId,
        config.gameId,
        config.gameVersion,
        index,
        config.pageSize,
        searchFilter,
        sectionId,
        config.sort
    )

    constructor(config: TwitchConfig, searchFilter: String = "", index: Long = 0) : this(
        config,
        0,
        index,
        searchFilter,
        6
    )
}
