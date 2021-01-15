package com.liquidforte.terra.server

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.liquidforte.terra.server.config.TerraConfig
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class TerraApplication : Application<TerraConfig>() {
    override fun initialize(bootstrap: Bootstrap<TerraConfig>?) {
        bootstrap?.objectMapper?.registerModule(KotlinModule())
    }

    override fun run(configuration: TerraConfig?, environment: Environment?) {

    }
}