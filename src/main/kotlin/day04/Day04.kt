package day04

import readInputFromFile

fun main() {
    println(part2())
}

fun part1(): Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day04\\Day04.txt")

    var passport = HashMap<String, String>()
    val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    var count = 0
    lines.forEach { line ->
        if (line.trim().isEmpty()) {
            if (requiredFields.all { passport.containsKey(it) }) {
                count++
            }
            passport.clear()
        } else {
            val pairs = line.split(" ")
            pairs.forEach { pair ->
                val (k, v) = pair.split(":")
                passport.put(k, v)
            }
        }
    }

    if (requiredFields.all { passport.containsKey(it) }) {
        count++
    }

    return count
}

fun part2(): Int {
    val lines = readInputFromFile("C:\\Data\\Kiril\\Sorsix\\aoc-2020-kotlin\\src\\main\\kotlin\\day04\\Day04.txt")

    var passport = HashMap<String, String>()
    val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    var count = 0
    lines.forEach { line ->
        if (line.trim().isEmpty()) {
            if (requiredFields.all { passport.containsKey(it) } && validatePassport(passport, requiredFields)) {
                count++
            }
            passport.clear()
        } else {
            val pairs = line.split(" ")
            pairs.forEach { pair ->
                val (k, v) = pair.split(":")
                passport.put(k, v)
            }
        }
    }

    if (requiredFields.all { passport.containsKey(it) }  && validatePassport(passport, requiredFields)) {
        count++
    }

    return count
}

fun validatePassport(passport: HashMap<String, String>, requiredFields: List<String>): Boolean {
    return passport.all {
        when(it.key) {
            "byr" -> validateBirthYear(it.value)
            "iyr" -> validateIssueYear(it.value)
            "eyr" -> validateExpirationYear(it.value)
            "hgt" -> validateHeight(it.value)
            "hcl" -> validateHairColor(it.value)
            "ecl" -> validateEyeColor(it.value)
            "pid" -> validatePassportId(it.value)
            else -> true
        }
    }
}

fun validatePassportId(pid: String): Boolean =
    pid.length == 9

fun validateEyeColor(ecl: String): Boolean {
    val validColors = "amb|blu|brn|gry|grn|hzl|oth"
    val pattern = Regex("($validColors)")
    return pattern.matches(ecl)
}

fun validateHairColor(hcl: String): Boolean {
    val pattern = Regex("#[0-9a-f]{6}")
    return pattern.matches(hcl)
}

fun validateHeight(hgt: String): Boolean {
    return if (hgt.contains("cm")) {
        val hgtInt = hgt.replace("cm", "").toInt()
        hgtInt in 150..193
    } else if (hgt.contains("in")) {
        val hgtInt = hgt.replace("in", "").toInt()
        hgtInt in 59..76
    } else {
        false
    }
}

fun validateExpirationYear(eyr: String): Boolean =
    eyr.length == 4 && eyr.toInt() in 2020..2030

fun validateIssueYear(iyr: String): Boolean =
    iyr.length == 4 && iyr.toInt() in 2010..2020

fun validateBirthYear(byr: String) =
    byr.length == 4 && byr.toInt() in 1920..2002
