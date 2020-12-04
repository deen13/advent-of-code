// Part One
val mandatory = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

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

object {}.javaClass.getResource("/day04.input")
    .readText()
    .lines()
    .chunkedOnThreshold { it.isEmpty() }
    .map { it.joinToString(separator = " ") }
    .map { it.split(" ") }
    .map { it.filter { t -> t.isNotBlank() } }
    .map { it.map { t -> t.substring(0, 3) } }
    .filter { it.containsAll(mandatory) }
    .count()

// Part Two
val conditions = mapOf(
    "ecl" to { v: String -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(v) },
    "pid" to { v: String -> v.length == 9 },
    "eyr" to { v: String -> (2020..2030).contains(v.toInt()) },
    "hcl" to { v: String -> Regex("""#[0-9a-f]{6}""").matches(v) },
    "byr" to { v: String -> (1920..2002).contains(v.toInt()) },
    "iyr" to { v: String -> (2010..2020).contains(v.toInt()) },
    "hgt" to { v: String ->
        if (v.endsWith("cm")) {
            (150..193).contains(v.removeSuffix("cm").toInt())
        } else {
            (59..76).contains(v.removeSuffix("in").toInt())
        }
    }
)

object {}.javaClass.getResource("/day04.input")
    .readText()
    .lines()
    .chunkedOnThreshold { it.isEmpty() }
    .map { it.joinToString(separator = " ") }
    .map { it.split(" ") }
    .map { it.filter { t -> t.isNotBlank() } }
    .map { it.map { t -> t.split(":") } }
    .map { it.map { (k, v) -> k to v }.toMap() }
    .filter { it.keys.containsAll(mandatory) }
    .filter { it.entries.all { isValid(it.key, it.value) } }
    .count()

fun isValid(key: String, value: String) = conditions[key]?.invoke(value) ?: true


