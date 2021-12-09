class Dive {

    companion object {
        fun calculateHorizontal(input: List<String>): Int {
            return input.filter { it.startsWith("forward") }.sumOf { it.findNumber() }
        }

        fun calculateDepth(input: List<String>): Int {
            return input.fold(0) { acc, cmd ->
                if (cmd.startsWith("up")) {
                    acc - cmd.findNumber()
                } else if (cmd.startsWith("down")) {
                    acc + cmd.findNumber()
                } else {
                    acc
                }
            }
        }

        fun calculateProduct(input: List<String>) = calculateDepth(input) * calculateHorizontal(input)

        fun calculateAimed(input: List<String>): Int {
            val position = input.fold(Position(0, 0, 0)) { pos, cmd ->
                if (cmd.startsWith("down")) {
                    pos.copy(aim = pos.aim + cmd.findNumber())
                } else if (cmd.startsWith("up")) {
                    pos.copy(aim = pos.aim - cmd.findNumber())
                } else {
                    pos.copy(
                        horizontal = pos.horizontal + cmd.findNumber(),
                        depth = pos.depth + (pos.aim * cmd.findNumber())
                    )
                }
            }

            return position.horizontal * position.depth
        }

        data class Position(val horizontal: Int, val aim: Int, val depth: Int)
    }
}

fun String.findNumber() = this.filter { it.isDigit() }.toInt()
