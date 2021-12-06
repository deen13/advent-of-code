class DayOne {

    companion object {
        fun countIncreases(input: List<Int>) = input.zipWithNext().count { (first, second) -> second > first }
        fun countWindowedIncreases(input: List<Int>) = countIncreases(input.windowed(3).map { it.sum() })
    }
}
