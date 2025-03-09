import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeTwo2DArray2570Test {

    @Test
    fun mergeArrays_1() {
        val result = mergeArrays(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 5)
            ),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(3, 2),
                intArrayOf(4, 1)
            )
        )

        assertArrayEquals(
            result,
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(2, 3),
                intArrayOf(3, 2),
                intArrayOf(4, 6)
            )
        )
    }

    @Test
    fun mergeArrays_2() {
        val result = mergeArrays(
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(3, 6),
                intArrayOf(5, 5)
            ),
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(4, 3)
            )
        )

        assertArrayEquals(
            result,
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 4),
                intArrayOf(3, 6),
                intArrayOf(4, 3),
                intArrayOf(5, 5)
            )
        )
    }
}