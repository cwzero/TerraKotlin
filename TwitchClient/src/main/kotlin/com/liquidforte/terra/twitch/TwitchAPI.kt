package com.liquidforte.terra.twitch

import com.liquidforte.terra.twitch.model.fingerprint.FingerprintMatch
import com.liquidforte.terra.twitch.model.addonsearch.AddonSearchRequest
import com.liquidforte.terra.twitch.model.addonsearch.AddonSearchResult
import com.liquidforte.terra.twitch.model.fingerprint.FingerprintResult
import com.liquidforte.terra.twitch.model.latestfile.LatestFile
import feign.Headers
import feign.Param
import feign.RequestLine

interface TwitchAPI {
    @RequestLine("GET /addon/{addonId}")
    fun getAddon(@Param("addonId") id: Long): AddonSearchResult

    @RequestLine("GET /addon/{addonId}/file/{fileId}")
    fun getFile(@Param("addonId") addonId: Long, @Param("fileId") fileId: Long): LatestFile

    @RequestLine("GET /addon/{addonId}/files")
    fun getFiles(@Param("addonId") addonId: Long): List<LatestFile>

    @RequestLine("GET /addon/search?categoryId={categoryId}&gameId={gameId}&gameVersion={gameVersion}&index={index}&pageSize={pageSize}&searchFilter={searchFilter}&sectionId={sectionId}&sort={sort}")
    fun addonSearch(
        @Param("categoryId") categoryId: Long, @Param("gameId") gameId: Long,
        @Param("gameVersion") gameVersion: String, @Param("index") index: Long, @Param("pageSize") pageSize: Long,
        @Param("searchFilter") searchFilter: String, @Param("sectionId") sectionId: Long, @Param("sort") sort: Long
    ): List<AddonSearchResult>

    @RequestLine("GET /addon/{addonId}/file/{fileId}/download-url")
    fun getDownloadUrl(@Param("addonId") addonId: Long, @Param("fileId") fileId: Long): String

    @RequestLine("POST /fingerprint")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun fingerprint(vararg fingerprints: Long): FingerprintResult
}

fun TwitchAPI.addonSearch(request: AddonSearchRequest): List<AddonSearchResult> =
    addonSearch(
        request.categoryId,
        request.gameId,
        request.gameVersion,
        request.index,
        request.pageSize,
        request.searchFilter,
        request.sectionId,
        request.sort
    )