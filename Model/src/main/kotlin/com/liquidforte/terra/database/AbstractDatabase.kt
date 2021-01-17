package com.liquidforte.terra.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import javax.sql.DataSource

abstract class AbstractDatabase : Database {
    override val pooledDataSource: DataSource
        get() = HikariDataSource(HikariConfig().apply {
            dataSource = this@AbstractDatabase.dataSource
            maximumPoolSize = 6
        })

    override val jdbi: Jdbi
        get() = Jdbi.create(pooledDataSource).installPlugins()
}