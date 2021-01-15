package com.liquidforte.terra.twitch.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import javax.ws.rs.ext.ContextResolver

class JacksonContextResolver(private val mapper: ObjectMapper) : ContextResolver<ObjectMapper> {
    override fun getContext(type: Class<*>?): ObjectMapper {
        return mapper
    }
}
