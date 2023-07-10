package day05

import readInputFromFile

fun main() {
    part2()
}

fun mapInput() =
    readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day05\\Day05.txt")
        .map { it.replace("F", "0").replace("B", "1") }
        .map { it.replace("L", "0").replace("R", "1") }
        .map { Pair(it.substring(0, 7).toInt(2), it.substring(7).toInt(2)) }
        .map { it.first * 8 + it.second }

fun part1() {
        mapInput()
        .maxOrNull()
        .let { println(it) }
}

fun part2() =
    mapInput()
        .sorted()
        .windowed(2)
        .filter { it.last() - it.first() == 2 }
        .let { println(it) }
