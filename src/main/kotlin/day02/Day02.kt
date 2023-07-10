package day02

import readInputFromFile

fun main() {
    // println(part1())
    println(part2())
}

fun part1(): Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day02\\Day02.txt")

    return lines.sumOf { checkValidPart1(it) }
}

fun part2() : Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day02\\Day02.txt")

    return lines.sumOf { checkValidPart2(it) }
}

fun checkValidPart1(line: String) : Int {
    val (policy, password) = line.split(":")
    val (range, letter) = policy.split("\\s+".toRegex())
    val (start, end) = range.split("-").map { it.toInt() }

    val count = password.count { it == letter.elementAt(0) }

    return if (count in start..end) 1 else 0
}

fun checkValidPart2(line: String): Int {
    val (policy, password) = line.split(":")
    val (indexes, letter) = policy.split("\\s+".toRegex())
    val (idx1, idx2) = indexes.split("-").map { it.toInt() }

    return if ((password.elementAt(idx1) == letter.elementAt(0)) xor (password.elementAt(idx2) == letter.elementAt(0))) {
        1
    } else {
        0
    }

//    return if (password.elementAt(idx1) != letter.elementAt(0) &&
//        password.elementAt(idx2) != letter.elementAt(0)) {
//        0
//    } else if (password.elementAt(idx1) == password.elementAt(idx2)) {
//        0
//    } else {
//        1
//    }
}