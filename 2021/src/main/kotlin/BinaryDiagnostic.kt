class BinaryDiagnostic {

    companion object {
        fun convertInput(input: String): Array<IntArray> {
            return input.lines()
                .filterNot { it.isEmpty() }
                .map { it.toList().map { char -> Character.getNumericValue(char) }.toIntArray() }
                .toTypedArray()
        }

        private fun countBits(column: IntArray) = column.toList().groupingBy { it }.eachCount()

        fun findMostCommonBit(column: IntArray): Int {
            val count = countBits(column)

            return if (count[0] == count[1]) {
                1
            } else {
                count.maxByOrNull { it.value }!!.key
            }
        }

        fun findLeastCommonBit(column: IntArray): Int {
            val count = countBits(column)

            return if (count[0] == count[1]) {
                0
            } else {
                count.minByOrNull { it.value }!!.key
            }
        }

        fun findGammaRate(matrix: Array<IntArray>): Int {
            return transposeMatrix(matrix).map { findMostCommonBit(it) }.joinToString(separator = "").toInt(2)
        }

        fun findEpsilonRate(matrix: Array<IntArray>): Int {
            return transposeMatrix(matrix).map { findLeastCommonBit(it) }.joinToString(separator = "").toInt(2)
        }

        fun findPowerConsumption(matrix: Array<IntArray>) = findGammaRate(matrix) * findEpsilonRate(matrix)

        fun findOxygenRating(matrix: Array<IntArray>, i: Int = 0): Int {
            return if (matrix.size == 1) {
                matrix.single().joinToString(separator = "").toInt(2)
            } else {
                val mostCommonBit = findMostCommonBit(matrix.map { it[i] }.toIntArray())
                findOxygenRating(matrix.filter { it[i] == mostCommonBit }.toTypedArray(), i + 1)
            }
        }

        fun findScrubberRating(matrix: Array<IntArray>, i: Int = 0): Int {
            return if (matrix.size == 1) {
                matrix.single().joinToString(separator = "").toInt(2)
            } else {
                val leastCommonBit = findLeastCommonBit(matrix.map { it[i] }.toIntArray())
                findScrubberRating(matrix.filter { it[i] == leastCommonBit }.toTypedArray(), i + 1)
            }
        }

        fun findLifeSupportRating(matrix: Array<IntArray>) = findOxygenRating(matrix) * findScrubberRating(matrix)
    }
}
