import java.io.File

fun readInputFromFile(path: String): List<String> =
    File(path).readLines()

fun readInputFromFileAsInts(path: String): List<Int> =
    readInputFromFile(path).map { it.toInt() }