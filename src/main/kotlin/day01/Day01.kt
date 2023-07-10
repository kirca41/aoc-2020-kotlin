package day01

import readInputFromFileAsInts

fun main() {
    println(part1()?.let { (a, b) -> a * b })
    println(part2()?.let { (a, b, c) -> a * b * c })
}

fun part1(): Pair<Int, Int>? {
    val numbers = readInputFromFileAsInts("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day01\\Day01.txt")

    val complements = numbers.associateBy { 2020 - it }
    return numbers.mapNotNull {
        val complement = complements[it]
        if (complement != null) Pair(it, complement) else null
    }.firstOrNull()
}

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
}

fun List<Int>.findTriple(): Triple<Int, Int, Int>? {
    return firstNotNullOfOrNull { n ->
        findPairOfSum(2020 - n)?.let { pair -> Triple(n, pair.first, pair.second) }
    }
}

fun part2(): Triple<Int, Int, Int>? {
    val numbers = readInputFromFileAsInts("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day01\\Day01.txt")

    val complementPairs = numbers.associateWith { numbers.findPairOfSum(2020 - it) }

    return numbers.findTriple()
}