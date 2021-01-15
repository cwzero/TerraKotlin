package com.liquidforte.terra.server.config

import io.dropwizard.Configuration

data class TerraConfig(
    val configTest: String
) : Configuration()