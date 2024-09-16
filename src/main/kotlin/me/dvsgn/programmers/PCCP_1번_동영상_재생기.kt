package me.dvsgn.programmers

import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class PCCP_1번_동영상_재생기 {
    class Solution {
        fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
            val videoPlayer = VideoPlayer(
                length = stringToLocalTime(video_len),
                position = stringToLocalTime(pos),
                openingStart = stringToLocalTime(op_start),
                openingEnd = stringToLocalTime(op_end)
            )
            
            commands.forEach { command ->
                when (command) {
                    "next" -> videoPlayer.next()
                    "prev" -> videoPlayer.prev()
                    else -> {}
                }

                println("videoPlayer.getPosition() = ${videoPlayer.getPosition()}")
            }

            return videoPlayer.getPosition()
        }

        private fun stringToLocalTime(length: String): LocalTime {
            val times = length.split(':').map { it.toInt() }
            return LocalTime.of(0, times[0], times[1])
        }
    }

    class VideoPlayer(
        private val length: LocalTime,
        private var position: LocalTime,
        private val openingStart: LocalTime,
        private val openingEnd: LocalTime,
    ) {
        companion object {
            private val MOVE_DURATION = Duration.ofSeconds(10L)
            private val FORMAT = DateTimeFormatter.ofPattern("mm:ss")
        }

        fun prev() {
            skipOpening()

            val newTime = position.minus(MOVE_DURATION)

            position = if (position.minute == 0 && position.second - 10 <= 0) {
                LocalTime.MIDNIGHT
            } else {
                newTime
            }

            skipOpening()
        }

        fun next() {
            skipOpening()

            val newTime = position.plus(MOVE_DURATION)

            position = if (newTime.isAfter(length)) {
                length
            } else {
                newTime
            }

            skipOpening()
        }

        private fun skipOpening() {
            if (isOpening()) {
                position = openingEnd
            }
        }

        private fun isOpening(): Boolean {
            return !position.isBefore(openingStart) && !position.isAfter(openingEnd)
        }

        fun getPosition(): String {
            return position.format(FORMAT)
        }
    }
}

fun main() {
    val solution = PCCP_1번_동영상_재생기.Solution()

//    solution.solution("34:33", "13:00", "00:55", "02:55", arrayOf("next", "prev"))
    solution.solution(	"10:55", "00:05", "00:15", "06:55", arrayOf("prev", "next", "next"))
//    println(solution.solution("07:22", "04:05", "00:15", "04:07", arrayOf("next")))
}