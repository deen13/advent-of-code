data class RawElement(val name: String, val count: Int)

sealed class Tree {
    data class Root(val name: String, val nodes: List<Node>) : Tree() {

        val totalCount = this.nodes.sumBy { it.totalCount }

        fun contains(name: String): Boolean {
            return this.nodes.any { it.contains(name) }
        }
    }

    data class Node(val name: String, val count: Int, val nodes: List<Node>) : Tree() {

        val totalCount: Int = if (nodes.isEmpty()) {
            this.count
        } else {
            this.count + this.count * this.nodes.sumBy { it.totalCount }
        }

        fun contains(name: String): Boolean {
            return this.name == name || this.nodes.any { it.contains(name) }
        }
    }
}

val childrenSelector: (List<String>) -> List<RawElement> = { line ->
    line.drop(2).windowed(3, 3).map { child ->
        RawElement(child.drop(1).joinToString(separator = " "), child.first().toInt())
    }
}

val nameSelector: (List<String>) -> String = { it.take(2).joinToString(separator = " ") }

val lines: Map<String, List<RawElement>> = object {}.javaClass.getResource("/day07.input")
    .readText()
    .lines()
    .filterNot { it.contains("no other") }
    .map { it.replace("""bags|bag|contain|,|\.""".toRegex(), "") }
    .map { it.split("""\s+""".toRegex()) }
    .associateBy(nameSelector, childrenSelector)

val tree = lines.map { (name, children) -> Tree.Root(name, children.flatMap { convert(it, root = true) }) }

fun convert(element: RawElement, root: Boolean = false): List<Tree.Node> {
    val elements: List<RawElement> = lines.getOrDefault(element.name, emptyList())
    val children = elements.map { Tree.Node(it.name, it.count, convert(it)) }

    return if (root) {
        listOf(Tree.Node(element.name, element.count, children))
    } else {
        children
    }
}

println(tree.filter { it.contains("shiny gold") }.map { it.name }.size) // Part One: 126
println(tree.first { it.name == "shiny gold" }.totalCount) // Part Two: 220149
