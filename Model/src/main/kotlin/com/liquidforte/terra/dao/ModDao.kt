package com.liquidforte.terra.dao

import com.liquidforte.terra.model.Mod
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

interface ModDao {
    @SqlUpdate("""CREATE TABLE IF NOT EXISTS MOD(
        ID BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        SLUG VARCHAR NOT NULL UNIQUE,
        CURSE_FORGE_ID INTEGER NOT NULL UNIQUE)""")
    fun createTable()

    @SqlUpdate("INSERT INTO MOD(SLUG, CURSE_FORGE_ID) VALUES (:slug, :curseForgeId)")
    @RegisterBeanMapper(Mod::class)
    fun insert(@BindBean mod: Mod)

    @SqlQuery("SELECT ID FROM MOD WHERE SLUG = :slug")
    @RegisterBeanMapper(Mod::class)
    fun getId(@BindBean mod: Mod) : Long

    @SqlQuery("SELECT * FROM MOD WHERE SLUG = :slug")
    fun findMod(@Bind("slug") slug: String) : Optional<Mod>
}