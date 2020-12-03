val trees = object {}.javaClass.getResource("/day03.input")
    .readText()
    .lines()
    .asSequence()
    .filterNot { it.isEmpty() }
    .mapIndexed { i, l -> l[((i) * 3) % 31] }
    .count { it == '#' }

println(trees)
