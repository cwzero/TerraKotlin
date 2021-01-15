package com.liquidforte.terra.twitch.model.latestfile

import java.util.*

data class LatestFile(
    val id: Long,
    val displayName: String,
    val fileName: String,
    val fileDate: Date,
    val fileLength: Long,
    val releaseType: Long,
    val fileStatus: Long,
    val downloadUrl: String,
    val isAlternate: Boolean,
    val alternateFileId: Long,
    val isAvailable: Boolean,
    val packageFingerprint: Long,
    val gameVersion: List<String>,
    val hasInstallScript: Boolean,
    val isCompatibleWithClient: Boolean,
    val categorySectionPackageType: Long,
    val restrictProjectFileAccess: Long,
    val projectStatus: Long,
    val renderCacheId: Long,
    val packageFingerPrintId: Long,
    val gameVersionDateReleased: Date,
    val gameVersionMappingId: Long,
    val gameVersionId: Long,
    val gameId: Long,
    val isServerPack: Boolean,
) {
    val dependencies: MutableList<LatestFileDependency> = mutableListOf()
    val modules: MutableList<LatestFileModule> = mutableListOf()
    val sortableGameVersions: MutableList<SortableGameVersion> = mutableListOf()
}
