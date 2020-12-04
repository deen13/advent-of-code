val result = object {}.javaClass.getResource("/day04.input")
    .readText()
    .lines()
    .chunkedOnThreshold { it.isEmpty() }
    .map { it.joinToString(separator = " ") }
    .map { it.split(" ") }
    .map { it.filter { t -> t.isNotBlank() } }
    .map { it.map { t -> t.substring(0, 3) } }
    .filter { it.containsAll(listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")) }
    .count()

println(result)

fun <T> List<T>.chunkedOnThreshold(condition: (T) -> Boolean): Sequence<List<T>> = sequence {
    val buffer = mutableListOf<T>()
    for (element in this@chunkedOnThreshold.dropLast(1)) {
        buffer += element
        if (condition(element)) {
            yield(buffer)
            buffer.clear()
        }
    }
    if (buffer.isNotEmpty()) yield(buffer)
}
