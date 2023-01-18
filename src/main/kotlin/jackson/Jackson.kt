package jackson

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jackson.domain.Application
import jackson.write.ApplicationWrite

object jacksonMapper {
    val mapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .registerModule(JavaTimeModule())
}

fun serialize(application: Application): String {
    val jsonString = jacksonMapper.mapper.writeValueAsString(application)
    println(jsonString)
    return jsonString
}

fun deserialize(jsonString: String) =
    jacksonMapper.mapper.readValue(jsonString, ApplicationWrite::class.java)