// Part One
val result = object {}.javaClass.getResource("/day03.input")
    .readText()
    .lines()
    .asSequence()
    .filterNot { it.isEmpty() }
    .mapIndexed { i, l -> l[((i) * 3) % l.length] }
    .count { it == '#' }

println(result)
