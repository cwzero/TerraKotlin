package com.liquidforte.terra.dao

import com.liquidforte.terra.model.File
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

interface FileDao {
    @SqlUpdate("""
        CREATE TABLE FILE(
            ID BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
            MOD_ID BIGINT NOT NULL,
            DISPLAY_NAME VARCHAR NOT NULL,
            FILE_NAME VARCHAR NOT NULL UNIQUE,
            FILE_DATE DATETIME NOT NULL,
            FILE_LENGTH INT NOT NULL,
            DOWNLOAD_URL VARCHAR NOT NULL,
            FOREIGN KEY MOD_ID REFERENCES MOD(ID)
        )
    """)
    fun createTable()

    @SqlUpdate("""INSERT INTO FILE
            (MOD_ID, DISPLAY_NAME, FILE_NAME, FILE_DATE, FILE_LENGTH, DOWNLOAD_URL) 
        VALUES
            (:mod.id, :displayName, :fileName, :fileDate, :fileLength, :downloadUrl)""")
    @RegisterBeanMapper(File::class)
    fun insert(@BindBean file: File)

    @SqlQuery("SELECT ID FROM FILE WHERE CURSE_FORGE_ID = :curseForgeId")
    @RegisterBeanMapper(File::class)
    fun getId(@BindBean file: File) : Long

    @SqlQuery("SELECT * FROM FILE WHERE CURSE_FORGE_ID = :curseForgeId")
    fun getId(@Bind("curseForgeId") curseForgeId: Long) : Optional<File>
}