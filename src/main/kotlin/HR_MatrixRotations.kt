import java.math.BigInteger

fun main() {
//    val input = arrayOf(
//        arrayOf( 1, 2, 3, 4, 5),
//        arrayOf(12, 1, 2, 5, 6),
//        arrayOf(11, 4, 3, 6, 7),
//        arrayOf(10, 9, 8, 7, 8),
//        arrayOf(10, 9, 8, 7, 8)
//    )

    val input = arrayOf(
        arrayOf(9718805,60013003,5103628,85388216,21884498,38021292,73470430,31785927),
        arrayOf(69999937,71783860,10329789,96382322,71055337,30247265,96087879,93754371),
        arrayOf(79943507,75398396,38446081,34699742,1408833,51189,17741775,53195748),
        arrayOf(79354991,26629304,86523163,67042516,54688734,54630910,6967117,90198864),
        arrayOf(84146680,27762534,6331115,5932542,29446517,15654690,92837327,91644840),
        arrayOf(58623600,69622764,2218936,58592832,49558405,17112485,38615864,32720798),
        arrayOf(49469904,5270000,32589026,56425665,23544383,90502426,63729346,35319547),
        arrayOf(20888810,97945481,85669747,88915819,96642353,42430633,47265349,89653362),
        arrayOf(55349226,10844931,25289229,90786953,22590518,54702481,71197978,50410021),
        arrayOf(9392211,31297360,27353496,56239301,7071172,61983443,86544343,43779176)
    )

    /*
    93754371 53195748 90198864 91644840 32720798 35319547 89653362 50410021
    31785927 25289229 10844931 97945481 5270000  69622764 27762534 43779176
    73470430 90786953 42430633 96642353 88915819 85669747 26629304 86544343
    38021292 22590518 90502426 67042516 54688734 32589026 75398396 61983443
    21884498 54702481 17112485 5932542  29446517 2218936  71783860 7071172
    85388216 71197978 15654690 58592832 49558405 6331115  10329789 56239301
    5103628  47265349 54630910 56425665 23544383 86523163 96382322 27353496
    60013003 63729346 51189    1408833  34699742 38446081 71055337 31297360
    9718805  38615864 92837327 6967117  17741775 96087879 30247265 9392211
    69999937 79943507 79354991 84146680 58623600 49469904 20888810 55349226
     */

    matrixRotation(input, 40)
}

fun matrixRotation(matrix: Array<Array<Int>>, r: Int) {
    val width = matrix.get(0).size
    val height = matrix.size

    val xe = width - 1
    val ye = height - 1

    matrixRotation(matrix, 0, 0, xe, ye, r)

    matrix.forEach { println(it.joinToString(separator = " "))}
}

fun matrixRotation(matrix: Array<Array<Int>>, xs: Int, ys: Int, xe: Int, ye: Int, r: Int) {
    if(xs < xe && ys < ye) {
        // Determine width + height of current rectangle
        val width = xe - xs + 1
        val height = ye - ys + 1

        // Rotate only as many times as needed
        val numRotationsForFullRotation = (width * 2) + ((height - 2) * 2)
        val updatedR = r % numRotationsForFullRotation

        for (i in 1..updatedR) {
            val topLeft = matrix[ys][xs]
            val botRight = matrix[ye][xe]

            // Shift top row left
            for (x in xs until xe) {
                matrix[ys][x] = matrix[ys][x + 1]
            }

            // Shift bottom row right
            for (x in xe downTo xs + 1) {
                matrix[ye][x] = matrix[ye][x - 1]
            }

            // Shift right column up
            for (y in ys until ye - 1) {
                matrix[y][xe] = matrix[y + 1][xe]
            }
            // Backfill last right column item
            matrix[ye - 1][xe] = botRight

            // Shift left column down
            for (y in ye downTo ys + 2) {
                matrix[y][xs] = matrix[y - 1][xs]
            }
            // Backfill first left column item
            matrix[ys + 1][xs] = topLeft
        }

        matrixRotation(matrix, xs + 1, ys + 1, xe - 1, ye - 1, r)
    }
}