package com.liquidforte.terra.twitch.model.addonsearch

import com.liquidforte.terra.twitch.model.file.File
import java.util.*

data class AddonSearchResult(
    val id: Long,
    val name: String,
    val websiteUrl: String,
    val gameId: Long,
    val summary: String,
    val defaultFileId: Long,
    val downloadCount: Long,
    val status: Long,
    val primaryCategoryId: Long,
    val categorySection: AddonCategorySection,
    val slug: String,
    val isFeatured: Boolean,
    val popularityScore: Double,
    val gamePopularityRank: Long,
    val primaryLanguage: String,
    val gameSlug: String,
    val gameName: String,
    val portalName: String,
    val dateModified: Date,
    val dateCreated: Date,
    val dateReleased: Date,
    val isAvailable: Boolean,
    val isExperimental: Boolean
) {
    val authors: MutableList<AddonAuthor> = mutableListOf()
    val attachments: MutableList<AddonAttachment> = mutableListOf()
    val files: MutableList<File> = mutableListOf()
    val categories: MutableList<AddonSearchCategory> = mutableListOf()
    val gameVersionLatestFiles: MutableList<GameVersionLatestFile> = mutableListOf()
}