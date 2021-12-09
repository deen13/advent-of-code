class GiantSquid {

    companion object {
        fun findScore(boards: List<Board>, history: List<Int>): Int {
            for(i in (1..history.size)) {
                val partialHistory = history.subList(0, i)

                val board = boards.find { it.hasWon(partialHistory) }

                if(board != null) {
                    val unmarked = board.findUnmarked(partialHistory)
                    val lastCall = partialHistory.last()

                    return unmarked.sum() * lastCall
                }
            }

            return -1
        }
    }

    class Board(private val board: Array<IntArray>) {

        private val columns = transposeMatrix(board)

        fun hasWon(history: List<Int>): Boolean {
            return (board + columns).any { axis -> axis.intersect(history).size == 5 }
        }

        fun findUnmarked(history: List<Int>) = board.flatMap { it.asIterable() } - history
    }
}
