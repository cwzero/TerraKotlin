package com.liquidforte.terra.twitch.jackson

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MultiDateDeserializer(vc: Class<Any>? = null) : StdDeserializer<Date>(vc) {
    companion object {
        val DATE_FORMATS = listOf(
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'"
        )
    }

    override fun deserialize(jp: JsonParser?, ctxt: DeserializationContext?): Date {
        val node: JsonNode = jp?.getCodec()?.readTree(jp)!!
        val date = node.textValue()

        for (DATE_FORMAT in DATE_FORMATS) {
            try {
                return SimpleDateFormat(DATE_FORMAT).parse(date)
            } catch (e: ParseException) {
            }
        }
        throw JsonParseException(
            jp,
            "Unparseable date: \"$date\". Supported formats: $DATE_FORMATS"
        )
    }
}