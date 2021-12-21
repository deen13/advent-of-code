import java.io.File
import kotlin.test.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GiantSquidTests {

    @Test
    fun `has won by row`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
                intArrayOf(65, 58, 91, 23, 36),
                intArrayOf(77, 60, 49, 43, 95),
                intArrayOf(13, 21, 56, 78, 99)
            )
        )

        val hasWon = board.hasWon(listOf(25, 83, 15, 27, 22))

        expectThat(hasWon).isEqualTo(true)
    }

    @Test
    fun `has won by last row`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
                intArrayOf(65, 58, 91, 23, 36),
                intArrayOf(77, 60, 49, 43, 95),
                intArrayOf(13, 21, 56, 78, 99)
            )
        )

        val hasWon = board.hasWon(listOf(13, 21, 56, 78, 99))

        expectThat(hasWon).isEqualTo(true)
    }

    @Test
    fun `has won by column`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
                intArrayOf(65, 58, 91, 23, 36),
                intArrayOf(77, 60, 49, 43, 95),
                intArrayOf(13, 21, 56, 78, 99)
            )
        )

        val hasWon = board.hasWon(listOf(25, 97, 65, 77, 13))

        expectThat(hasWon).isEqualTo(true)
    }

    @Test
    fun `has won by last column`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
                intArrayOf(65, 58, 91, 23, 36),
                intArrayOf(77, 60, 49, 43, 95),
                intArrayOf(13, 21, 56, 78, 99)
            )
        )

        val hasWon = board.hasWon(listOf(22, 52, 36, 95, 99))

        expectThat(hasWon).isEqualTo(true)
    }

    @Test
    fun `has not won yet`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
                intArrayOf(65, 58, 91, 23, 36),
                intArrayOf(77, 60, 49, 43, 95),
                intArrayOf(13, 21, 56, 78, 99)
            )
        )

        val hasWon = board.hasWon(listOf(25, 83, 15, 27))

        expectThat(hasWon).isEqualTo(false)
    }

    @Test
    fun `find unmarked`() {
        val board = GiantSquid.Board(
            arrayOf(
                intArrayOf(25, 83, 15, 27, 22),
                intArrayOf(97, 81, 12, 80, 52),
            )
        )

        val unmarked = board.findUnmarked(listOf(25, 83, 15, 81, 12, 27, 22))

        expectThat(unmarked).isEqualTo(listOf(97, 80, 52))
    }

    @Test
    fun `part one`() {
        val input = File("src/test/resources/Day4Part1.txt").readLines()

        val history = GiantSquid.parseHistory(input)
        val boards = GiantSquid.parseBoards(input)

        expectThat(GiantSquid.findScore(boards, history)).isEqualTo(50008)
    }
}
