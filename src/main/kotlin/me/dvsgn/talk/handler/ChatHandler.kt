package me.dvsgn.talk.handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

data class ChatMessage(val sender: String, val content: String)

class ChatHandler : TextWebSocketHandler() {
    private val sessions = mutableSetOf<WebSocketSession>()
    private val objectMapper = jacksonObjectMapper()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
        println("New connection: ${session.id}")
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val chatMessage: ChatMessage = objectMapper.readValue(message.payload)

        // Broadcast message to all clients
        val broadcastMessage = objectMapper.writeValueAsString(chatMessage)
        sessions.forEach {
            it.sendMessage(TextMessage(broadcastMessage))
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: org.springframework.web.socket.CloseStatus) {
        sessions.remove(session)
        println("Connection closed: ${session.id}")
    }
}