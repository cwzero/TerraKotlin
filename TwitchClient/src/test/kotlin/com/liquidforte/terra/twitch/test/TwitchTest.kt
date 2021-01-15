package com.liquidforte.terra.twitch.test

import com.fasterxml.jackson.databind.ObjectMapper
import com.liquidforte.terra.twitch.TwitchAPI
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.jaxrs2.JAXRSClient
import org.junit.jupiter.api.Test
import javax.ws.rs.client.ClientBuilder
import com.fasterxml.jackson.databind.ser.std.DateSerializer

import com.fasterxml.jackson.databind.module.SimpleModule

import com.fasterxml.jackson.core.util.DefaultIndenter

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter

import com.fasterxml.jackson.databind.SerializationFeature

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.liquidforte.terra.twitch.addonSearch
import com.liquidforte.terra.twitch.config.TwitchConfig
import com.liquidforte.terra.twitch.jackson.MultiDateDeserializer
import com.liquidforte.terra.twitch.model.addonsearch.AddonSearchRequest
import feign.Logger
import feign.slf4j.Slf4jLogger
import java.util.*


class TwitchTest {
    @Test
    fun test() {
        val url = "https://addons-ecs.forgesvc.net/api/v2"
        val builder = Feign.builder()

        val mapper = ObjectMapper().findAndRegisterModules()

        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        val prettyPrinter = DefaultPrettyPrinter()
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE)

        mapper.setDefaultPrettyPrinter(prettyPrinter)

        val module = SimpleModule()
        module.addSerializer(Date::class.java, DateSerializer())
        module.addDeserializer(Date::class.java, MultiDateDeserializer())
        mapper.registerModule(module)

        val client = builder
            .logger(Slf4jLogger())
            .logLevel(Logger.Level.BASIC)
            .client(JAXRSClient(ClientBuilder.newBuilder()))
            .decoder(JacksonDecoder(mapper))
            .encoder(JacksonEncoder(mapper))
            .target(TwitchAPI::class.java, url)

        val config = TwitchConfig()

        val request = AddonSearchRequest(config, "rftools")

        val addons = client.addonSearch(request)

        println(addons)
    }
}