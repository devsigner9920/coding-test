package me.dvsgn.test

import kotlinx.coroutines.*
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

suspend fun main(args: Array<String>) = coroutineScope {
    val fileName = args[0]

    val file = File("statistics/$fileName")

    val lines = withContext(Dispatchers.IO) { file.readLines() }
        .mapIndexed { index, s ->
            index + 1 to s
        }

    val workdir = File("htmls")
    if (!workdir.exists()) {
        workdir.mkdirs()
    } else {
        workdir.listFiles()?.forEach { it.delete() }
    }

    withContext(Dispatchers.IO) {
        lines.forEach { (index, url) ->
            launch {
                downloadHtml(url, index)
            }
        }
    }
}

suspend fun downloadHtml(urlString: String, index: Int) = coroutineScope {
    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    val file = File("htmls/$index.html")
    val byeArray = runCatching {
        connection.requestMethod = "GET"
        connection.connectTimeout = 3000
        connection.readTimeout = 3000

        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            return@runCatching connection.inputStream.readAllBytes()
        } else {
            throw Exception("Failed to download html")
        }
    }.getOrElse {
        println("Error downloading ${it.message}")
        "FAILED".toByteArray(Charsets.UTF_8)
    }

    file.outputStream().use { fileOutputStream ->
        fileOutputStream.write(byeArray)
    }
}
