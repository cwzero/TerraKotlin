package com.liquidforte.terra.twitch.config

data class TwitchConfig(
    val pageSize: Long = 1000,
    val sort: Long = 5,
    val gameId: Long = 432,
    val gameVersion: String = "1.16.4"
)
