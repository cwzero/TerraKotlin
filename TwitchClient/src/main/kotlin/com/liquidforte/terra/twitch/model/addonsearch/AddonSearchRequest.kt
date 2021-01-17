package com.liquidforte.terra.twitch.model.addonsearch

import com.liquidforte.terra.twitch.config.TwitchConfig

data class AddonSearchRequest(
    var categoryId: Long = 0,
    var gameId: Long = 432,
    var gameVersion: String = "1.16.4",
    var index: Long = 0,
    var pageSize: Long = 1000,
    var searchFilter: String = "",
    var sectionId: Long = 6,
    var sort: Long = 5
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
