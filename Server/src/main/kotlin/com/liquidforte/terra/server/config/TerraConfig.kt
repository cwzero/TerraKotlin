package com.liquidforte.terra.server.config

import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class TerraConfig(
    val configTest: String
) : Configuration() {
    @Valid
    @NotNull
    var database: DataSourceFactory = DataSourceFactory()
}