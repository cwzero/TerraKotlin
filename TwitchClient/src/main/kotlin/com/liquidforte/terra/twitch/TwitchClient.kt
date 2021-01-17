package com.liquidforte.terra.twitch

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.DateSerializer
import com.liquidforte.terra.twitch.jackson.MultiDateDeserializer
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.jaxrs2.JAXRSClient
import feign.slf4j.Slf4jLogger
import java.util.*
import javax.ws.rs.client.ClientBuilder

object TwitchClient {
    val twitch: TwitchAPI
        get() {
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

            return builder
                .logger(Slf4jLogger())
                .logLevel(Logger.Level.BASIC)
                .client(JAXRSClient(ClientBuilder.newBuilder()))
                .decoder(JacksonDecoder(mapper))
                .encoder(JacksonEncoder(mapper))
                .target(TwitchAPI::class.java, url)
        }
}