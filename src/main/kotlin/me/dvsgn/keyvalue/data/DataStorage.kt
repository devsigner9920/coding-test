package me.dvsgn.keyvalue.data

interface DataStorage {
    fun get(key: String): String?
    fun set(key: String, value: String)
    fun expire(key: String, seconds: Long)
}
