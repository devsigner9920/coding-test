package me.dvsgn.keyvalue.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class DefaultDataStorage(
    private val data: ConcurrentMap<String, DataConstructor> = ConcurrentHashMap()
): DataStorage {
    init {
        val file = File("statistics/data.json")
        val objectMapper = jacksonObjectMapper()
        if (file.exists()) {
            val testData: Map<String, DataConstructor> = objectMapper.readValue(file)
            data.putAll(testData)
        }

        println(data)
    }
    override fun get(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun set(key: String, value: String) {
        data[key] = DataConstructor(value, -1)
    }

    override fun expire(key: String, seconds: Long) {

    }
}