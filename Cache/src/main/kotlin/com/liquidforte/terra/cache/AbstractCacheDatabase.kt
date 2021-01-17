package com.liquidforte.terra.cache

import com.liquidforte.terra.database.AbstractDatabase
import org.h2.jdbcx.JdbcDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.h2.H2DatabasePlugin
import javax.sql.DataSource

abstract class AbstractCacheDatabase(private val name: String) : AbstractDatabase() {
    override val dataSource: DataSource
        get() = JdbcDataSource().apply {
            user = "terra"
            password = "terra"
            setURL(dbUrlBase + name)
        }

    override val jdbi: Jdbi
        get() = Jdbi.create(pooledDataSource).installPlugin(H2DatabasePlugin())

    companion object {
        private const val dbUrlBase = "jdbc:h2:tcp://localhost/~/.terra/db/"
    }
}