package me.dvsgn.keyvalue

import me.dvsgn.keyvalue.data.DefaultDataStorage
import me.dvsgn.keyvalue.tcp.TcpHandler
import me.dvsgn.keyvalue.udp.UdpHandler
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.ServerSocket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


fun main() {
    val tcpPort = 9090
    val udpPort = 9091

    val dataStorage = DefaultDataStorage()
    val tcpThread = Executors.newSingleThreadExecutor()
    val udpThread = Executors.newSingleThreadExecutor()

    Thread { startTcpHttpServer(tcpPort, tcpThread, dataStorage) }.start()
    Thread { startUdpServer(udpPort, udpThread, dataStorage) }.start()
}

fun startTcpHttpServer(tcpPort: Int, tcpThread: ExecutorService, dataStorage: DefaultDataStorage) {
    val serverSocket = ServerSocket(tcpPort)

    while (true) {
        val clientSocket = serverSocket.accept()
        tcpThread.submit {
            val tcpHandler = TcpHandler(dataStorage)
            tcpHandler.handle(clientSocket)
        }
    }
}

fun startUdpServer(udpPort: Int, udpThread: ExecutorService, dataStorage: DefaultDataStorage) {
    val udpSocket = DatagramSocket(udpPort)

    val buffer = ByteArray(1024)

    while (true) {
        val packet = DatagramPacket(buffer, buffer.size)
        udpSocket.receive(packet)

        udpThread.submit {
            val udpHandler = UdpHandler(dataStorage)
            udpHandler.handle(packet, udpSocket)
        }
    }
}
