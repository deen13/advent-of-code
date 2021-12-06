class DayTwo {

    companion object {
        fun calculateHorizontal(input: List<String>): Int {
            return input.filter { it.startsWith("forward") }.sumOf { it.findNumber() }
        }

        fun calculateDepth(input: List<String>): Int {
            return input.fold(0) { acc, cmd ->
                if(cmd.startsWith("up")) {
                    acc - cmd.findNumber()
                } else if(cmd.startsWith("down")) {
                    acc + cmd.findNumber()
                } else {
                    acc
                }
            }
        }

        fun calculateProduct(input: List<String>) = calculateDepth(input) * calculateHorizontal(input)
    }
}

fun String.findNumber() = this.filter { it.isDigit() }.toInt()
