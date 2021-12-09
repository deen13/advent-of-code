import java.io.File
import kotlin.test.Ignore
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class BinaryDiagnosticTests {

    @Test
    fun `one is most common`() {
        val mostCommon = BinaryDiagnostic.findMostCommonBit(intArrayOf(1, 1, 0))

        expectThat(mostCommon).isEqualTo(1)
    }

    @Test
    fun `most common is one if bits are equally common`() {
        val mostCommon = BinaryDiagnostic.findMostCommonBit(intArrayOf(1, 0))

        expectThat(mostCommon).isEqualTo(1)
    }

    @Test
    fun `most common is not zero if bits are equally common`() {
        val mostCommon = BinaryDiagnostic.findMostCommonBit(intArrayOf(0, 1))

        expectThat(mostCommon).isEqualTo(1)
    }

    @Test
    fun `one is least common`() {
        val leastCommon = BinaryDiagnostic.findLeastCommonBit(intArrayOf(1, 1, 0))

        expectThat(leastCommon).isEqualTo(0)
    }

    @Test
    fun `least common is one if bits are equally common`() {
        val leastCommon = BinaryDiagnostic.findLeastCommonBit(intArrayOf(1, 0))

        expectThat(leastCommon).isEqualTo(0)
    }

    @Test
    fun `least common is not zero if bits are equally common`() {
        val leastCommon = BinaryDiagnostic.findLeastCommonBit(intArrayOf(0, 1))

        expectThat(leastCommon).isEqualTo(0)
    }

    @Test
    fun `find gamma rate`() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(0, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0),
        )

        val gammaRate: Int = BinaryDiagnostic.findGammaRate(matrix)

        expectThat(gammaRate).isEqualTo(22)
    }

    @Test
    fun `find epsilon rate`() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(0, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0),
        )

        val epsilonRate: Int = BinaryDiagnostic.findEpsilonRate(matrix)

        expectThat(epsilonRate).isEqualTo(9)
    }

    @Test
    fun `find power consumption`() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(0, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0),
        )

        val powerConsumption: Int = BinaryDiagnostic.findPowerConsumption(matrix)

        expectThat(powerConsumption).isEqualTo(198)
    }

    @Test
    fun `find life support rating`() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(0, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 1),
            intArrayOf(0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0),
        )

        val lifeSupportRating: Int = BinaryDiagnostic.findLifeSupportRating(matrix)

        expectThat(lifeSupportRating).isEqualTo(230)
    }

    @Test
    @Ignore
    fun `part one`() {
        val matrix = BinaryDiagnostic.convertInput(
            File("src/test/resources/Day3Part1.txt").readText()
        )

        val powerConsumption: Int = BinaryDiagnostic.findPowerConsumption(matrix)

        expectThat(powerConsumption).isEqualTo(2954600)
    }

    @Test
    fun `part two`() {
        val matrix = BinaryDiagnostic.convertInput(
            File("src/test/resources/Day3Part2.txt").readText()
        )

        val lifeSupportRating: Int = BinaryDiagnostic.findLifeSupportRating(matrix)

        expectThat(lifeSupportRating).isEqualTo(1662846)
    }
}
