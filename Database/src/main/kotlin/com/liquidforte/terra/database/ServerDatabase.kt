package com.liquidforte.terra.database

import org.postgresql.ds.PGSimpleDataSource
import java.sql.Connection
import java.sql.DriverManager
import javax.sql.DataSource

object ServerDatabase : AbstractDatabase() {
    private val rootConnection: Connection
        get() {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection("jdbc:postgresql://postgres/", "postgres", "terra")
        }

    override val dataSource: DataSource
        get() {
            initDb()
            return PGSimpleDataSource().apply {
                serverNames = arrayOf("postgres")
                databaseName = "terra"
                user = "postgres"
                password = "terra"
            }
        }

    fun initDb() {
        val connection = rootConnection
        val result = connection.createStatement().executeQuery("SELECT DATNAME FROM PG_DATABASE")
        val tables = arrayListOf<String>()

        while (result.next()) {
            tables.add(result.getString(1))
        }

        if (!tables.any { it.toUpperCase().contentEquals("TERRA") }) {
            connection.createStatement().execute("CREATE DATABASE TERRA")
        }
    }
}