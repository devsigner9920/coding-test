package me.dvsgn.keyvalue.tcp

import me.dvsgn.keyvalue.data.DataStorage
import java.io.BufferedReader
import java.io.BufferedWriter
import java.net.Socket
import java.net.URI

class TcpHandler(
    private val dataStorage: DataStorage
) {
    fun handle(clientSocket: Socket) {
        clientSocket.use { socket ->
            val input = socket.getInputStream().bufferedReader()
            val output = socket.getOutputStream().bufferedWriter()

            val requestLine = input.readLine() ?: return

            println("TCP received: $requestLine")

            if (requestLine.startsWith("GET") || requestLine.startsWith("POST") || requestLine.startsWith("PUT")) {
                handleHttpRequest(requestLine, input, output)
            } else {
                handleTcpReuqest(requestLine, input, output)
            }
        }
    }

    private fun handleHttpRequest(requestLine: String, input: BufferedReader, output: BufferedWriter) {
        val request = requestLine.split(" ")
        val method = request[0]
        val path = request[1]

        if (method == "GET") {
            handleHttpGet(path, output)
        } else if (method == "POST") {
            handleHttpPost(path, input, output)
        }
    }

    private fun handleHttpGet(path: String, output: BufferedWriter) {
        val uri = URI.create(path)
        val query = uri.query
        val queryMap = query?.split("&")?.associate {
            val (key, value) = it.split("=")
            key to value
        } ?: emptyMap()

        val key = queryMap["key"]
        output.write("HTTP/1.1 200 OK\r\n")
        output.write("Content-Type: text/plain\r\n")
        output.write("\r\n")
        output.write("Hello, World!")
        output.write("\r\n")
        output.flush()
    }

    private fun handleHttpPost(path: String, input: BufferedReader, output: BufferedWriter) {
        // HTTP 헤더 읽기
        val headers = mutableMapOf<String, String>()
        var line: String? = input.readLine()

        // 헤더 파싱
        while (!line.isNullOrEmpty()) {
            println(line) // 헤더 출력
            val parts = line.split(":", limit = 2)
            if (parts.size == 2) {
                headers[parts[0].trim()] = parts[1].trim()
            }
            line = input.readLine()
        }

        // Content-Length 확인
        val contentLength = headers["Content-Length"]?.toIntOrNull() ?: 0
        println("Content-Length: $contentLength")

        // 본문 데이터 읽기
        val body = CharArray(contentLength)
        input.read(body, 0, contentLength)
        println("Body: ${String(body)}")

        val parsedData = String(body).split("\\n").map { it.split("=").let { parts -> parts[0] to parts[1] } }
        println("Parsed Data: $parsedData")

        // 응답
        output.write("HTTP/1.1 200 OK\r\n")
        output.write("Content-Type: text/plain\r\n")
        output.write("\r\n")
        output.write("Received POST data: ${String(body)}\n")
        output.flush()
    }

    private fun handleTcpReuqest(requestLine: String, input: BufferedReader, output: BufferedWriter) {
        TODO("Not yet implemented")
    }
}