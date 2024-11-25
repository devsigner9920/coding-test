package me.dvsgn.test

import java.io.BufferedReader
import java.util.HashMap

fun main() {
    var br = BufferedReader(System.`in`.reader())

    var input = br.readLine().split(",")
    var first = input[0].split(" ").map { it.toInt() }
    var second = input[1].split(" ").map { it.toInt() }
    var rankCalculator = RankCalculator()

    var firstResult = rankCalculator.calculate(first)
    var secondResult = rankCalculator.calculate(second)

    println(WinnerChecker(firstResult, secondResult).check())
}

class RankCalculator {
    fun calculate(cards: List<Int>): Int {
        if (isFirst(cards)) return 1
        if (isSecond(cards)) return 2
        if (isThird(cards)) return 3
        if (isFourth(cards)) return 4
        if (isFifth(cards)) return 5

        return 6
    }

    private fun isFifth(cards: List<Int>): Boolean {
        return cards.toSet().size == 3
    }

    private fun isFourth(cards: List<Int>): Boolean {
        return cards.toSet().size == 2
    }

    private fun isThird(cards: List<Int>): Boolean {
        val map = HashMap<Int, Int>()
        cards.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        return map.containsValue(4)
    }

    private fun isSecond(cards: List<Int>): Boolean {
        val sorted = cards.sorted()
        for (i in 1 until cards.size) {
            if (sorted[i - 1] + 1 != sorted[i]) {
                return false
            }
        }

        return true;
    }

    private fun isFirst(cards: List<Int>) = cards.toSet().size == 1

}

class WinnerChecker(val firstResult: Int, val secondResult: Int) {
    fun check(): String {
        if (firstResult < secondResult) return "First"
        if (firstResult > secondResult) return "Second"

        return "Draw"
    }
}