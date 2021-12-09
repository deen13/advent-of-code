import java.io.File
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DiveTests {

    @Test
    fun `calculate horizontal`() {
        val input = listOf(
            "forward 1",
            "forward 5"
        )

        val horizontal = Dive.calculateHorizontal(input)

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

        val horizontal = Dive.calculateDepth(input)

        expectThat(horizontal).isEqualTo(10)
    }

    @Test
    fun `part one`() {
        val input = File("src/test/resources/Day2Part1.txt").readLines()

        val product = Dive.calculateProduct(input)

        expectThat(product).isEqualTo(1840243)
    }

    @Test
    fun `calculate aimed`() {
        val input = listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2"
        )

        val horizontal = Dive.calculateAimed(input)

        expectThat(horizontal).isEqualTo(900)
    }

    @Test
    fun `part two`() {
        val input = File("src/test/resources/Day2Part2.txt").readLines()

        val product = Dive.calculateAimed(input)

        expectThat(product).isEqualTo(1840243)
    }
}
