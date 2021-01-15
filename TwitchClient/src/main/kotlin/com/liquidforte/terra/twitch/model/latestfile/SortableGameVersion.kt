package com.liquidforte.terra.twitch.model.latestfile

import java.util.*

data class SortableGameVersion(
    val gameVersionPadded: String,
    val gameVersion: String,
    val gameVersionReleaseDate: Date,
    val gameVersionName: String
)
