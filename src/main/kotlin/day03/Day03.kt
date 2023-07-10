package day03

import readInputFromFile

fun main() {
    println(part2())
}

fun part1(): Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day03\\Day03.txt")

    return lines.checkSlope(3, 1)
}

fun part2(): Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day03\\Day03.txt")

    val r1d1 = lines.checkSlope(1, 1)
    val r3d1 = lines.checkSlope(3, 1)
    val r5d1 = lines.checkSlope(5, 1)
    val r7d1 = lines.checkSlope(7, 1)
    val r1d2 = lines.checkSlope(1, 2)

    return r1d1 * r3d1 * r5d1 * r7d1 * r1d2
}

fun List<String>.checkSlope(right: Int, down: Int): Int {
    var i = 0
    val it = if (down != 1) {
        slice(indices step down)
    } else {
        this
    }
    return it.drop(1).count {
        i += right
        it.elementAt(i % it.length) == '#'
    }
}