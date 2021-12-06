import java.io.File
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DayOneTests {

    @Test
    fun `one increased`() {
        val input = listOf(1, 2)

        val increases = DayOne.countIncreases(input)

        expectThat(increases).isEqualTo(1)
    }

    @Test
    fun `two increases`() {
        val input = listOf(1, 2, 3)

        val increases = DayOne.countIncreases(input)

        expectThat(increases).isEqualTo(2)
    }

    @Test
    fun `two increases with stagnation`() {
        val input = listOf(1, 2, 2, 3)

        val increases = DayOne.countIncreases(input)

        expectThat(increases).isEqualTo(2)
    }

    @Test
    fun `part one`() {
        val input = File("src/test/resources/Day1Part1.txt")
            .readLines()
            .map { it.toInt() }

        val increases = DayOne.countIncreases(input)

        expectThat(increases).isEqualTo(1715)
    }

    @Test
    fun `part two`() {
        val input = File("src/test/resources/Day1Part2.txt")
            .readLines()
            .map { it.toInt() }

        val increases = DayOne.countWindowedIncreases(input)

        expectThat(increases).isEqualTo(1715)
    }
}
