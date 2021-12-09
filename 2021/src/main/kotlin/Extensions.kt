fun transposeMatrix(matrix: Array<IntArray>): Array<IntArray> {
    val transpose = Array(matrix.first().size) { IntArray(matrix.size) }
    for (i in matrix.indices) {
        for (j in 0 until matrix.first().size) {
            transpose[j][i] = matrix[i][j]
        }
    }
    return transpose
}
