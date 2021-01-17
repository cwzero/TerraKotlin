package com.liquidforte.terra.rest.resource

import com.liquidforte.terra.dao.ModDao
import com.liquidforte.terra.database.ServerDatabase
import com.liquidforte.terra.model.File
import com.liquidforte.terra.model.Mod
import com.liquidforte.terra.twitch.TwitchClient
import com.liquidforte.terra.twitch.addonSearch
import com.liquidforte.terra.twitch.config.TwitchConfig
import com.liquidforte.terra.twitch.model.addonsearch.AddonSearchRequest
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/mod")
@Produces(MediaType.APPLICATION_JSON)
class ModResource {
    @GET
    @Path("/{slug}")
    fun getMod(@PathParam("slug") slug: String): Mod? =
        ServerDatabase.jdbi.withExtension<Mod, ModDao, Exception>(ModDao::class.java) { dao ->
            dao.createTable()
            dao.findMod(slug).orElseGet {
                val client = TwitchClient.twitch

                val searchResults = client.addonSearch(AddonSearchRequest(TwitchConfig(), slug))

                val result = searchResults.firstOrNull {
                    it.slug.contentEquals(slug)
                }

                if (result != null) {
                    // TODO: add mod to database
                    val mod = Mod(result.slug)
                    mod.curseForgeId = Optional.of(result.id)

                    dao.insert(mod)

                    val id = dao.getId(mod)
                    mod.id = Optional.of(id)

                    mod
                } else {
                    null
                }
            }
        }

    @GET
    @Path("/{slug}/files")
    fun getFiles(@PathParam("slug") slug: String): List<File> {
        val result = mutableListOf<File>()
        val mod = getMod(slug)

        if (mod != null) {
            val curseForgeId = mod.curseForgeId.get()
            val client = TwitchClient.twitch

            val files = client.getFiles(curseForgeId)

            files.forEach {
                val f = File(it.displayName, it.fileName, it.fileDate, it.fileLength, it.downloadUrl).apply {
                    this.curseForgeId = Optional.of(it.id)
                }

                result.add(f)
            }
        }

        return result
    }
}