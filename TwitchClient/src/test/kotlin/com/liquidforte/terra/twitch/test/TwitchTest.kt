package com.liquidforte.terra.twitch.test

import com.liquidforte.terra.twitch.TwitchClient
import com.liquidforte.terra.twitch.addonSearch
import com.liquidforte.terra.twitch.config.TwitchConfig
import com.liquidforte.terra.twitch.model.addonsearch.AddonSearchRequest
import org.junit.jupiter.api.Test

class TwitchTest {
    @Test
    fun test() {
        val client = TwitchClient.twitch

        val config = TwitchConfig()

        val request = AddonSearchRequest(config, "rftools")

        val addons = client.addonSearch(request)

        println(addons)
    }
}