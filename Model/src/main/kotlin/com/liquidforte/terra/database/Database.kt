package com.liquidforte.terra.database

import org.jdbi.v3.core.Jdbi
import javax.sql.DataSource

interface Database {
    val dataSource: DataSource
    val pooledDataSource: DataSource
    val jdbi: Jdbi
}