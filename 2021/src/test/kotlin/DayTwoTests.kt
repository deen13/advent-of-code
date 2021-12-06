import java.io.File
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DayTwoTests {

    @Test
    fun `calculate horizontal`() {
        val input = listOf(
            "forward 1",
            "forward 5"
        )

        val horizontal = DayTwo.calculateHorizontal(input)

        expectThat(horizontal).isEqualTo(6)
    }
    @Test
    fun `calculate depth`() {
        val input = listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2"
        )

        val horizontal = DayTwo.calculateDepth(input)

        expectThat(horizontal).isEqualTo(10)
    }

    @Test
    fun `part one`() {
        val input = File("src/test/resources/Day2Part1.txt").readLines()

        val product = DayTwo.calculateProduct(input)

        expectThat(product).isEqualTo(1840243)
    }
}
