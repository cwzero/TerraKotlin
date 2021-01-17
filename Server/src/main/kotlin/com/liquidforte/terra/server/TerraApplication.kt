package com.liquidforte.terra.server

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.liquidforte.terra.database.ServerDatabase
import com.liquidforte.terra.rest.resource.ModResource
import com.liquidforte.terra.server.config.TerraConfig
import io.dropwizard.Application
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class TerraApplication : Application<TerraConfig>() {
    override fun initialize(bootstrap: Bootstrap<TerraConfig>?) {
        bootstrap?.objectMapper?.registerModule(KotlinModule())
    }

    override fun run(configuration: TerraConfig?, environment: Environment?) {
        ServerDatabase.initDb()

        val factory = JdbiFactory()
        val jdbi = factory.build(environment, configuration?.database, "postgresql")

        jdbi.useHandle<Exception> { handle ->

        }

        val resource = ModResource()
        environment?.jersey()?.register(resource)
    }
}