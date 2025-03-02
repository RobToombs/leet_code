import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LexicographicallySmallest2948Test {

    @Test
    fun lexicographicallySmallestArray_1() {
        val result = lexicographicallySmallestArray(intArrayOf(1, 5, 3, 9, 8), 2)
        assertArrayEquals(result, intArrayOf(1, 3, 5, 8, 9))
    }

    @Test
    fun lexicographicallySmallestArray_2() {
        val result = lexicographicallySmallestArray(intArrayOf(1, 7, 6, 18, 2, 1), 3)
        assertArrayEquals(result, intArrayOf(1, 6, 7, 18, 1, 2))
    }

    @Test
    fun lexicographicallySmallestArray_3() {
        val result = lexicographicallySmallestArray(intArrayOf(1, 7, 28, 19, 10), 3)
        assertArrayEquals(result, intArrayOf(1, 7, 28, 19, 10))
    }

    @Test
    fun lexicographicallySmallestArray_4() {
        val result = lexicographicallySmallestArray(intArrayOf(1, 60, 34, 84, 62, 56, 39, 76, 49, 38), 4)
        assertArrayEquals(result, intArrayOf(1, 56, 34, 84, 60, 62, 38, 76, 49, 39))
    }

    @Test
    fun lexicographicallySmallestArray_5() {
        val result = lexicographicallySmallestArray(intArrayOf(1, 81, 10, 79, 36, 2, 87, 12, 20, 77), 7)
        assertArrayEquals(result, intArrayOf(1, 77, 10, 79, 36, 2, 81, 12, 20, 87))
    }

    @Test
    fun lexicographicallySmallestArray_6() {
        val result = lexicographicallySmallestArray(intArrayOf(81, 79, 87, 77), 7)
        assertArrayEquals(result, intArrayOf(77, 79, 81, 87))
    }

    @Test
    fun lexicographicallySmallestArray_7() {
        val result = lexicographicallySmallestArray(intArrayOf(87, 77), 10)
        assertArrayEquals(result, intArrayOf(77, 87))
    }

    @Test
    fun lexicographicallySmallestArray_8() {
        val result = lexicographicallySmallestArray(intArrayOf(4, 34, 29, 73, 51, 11, 8, 53, 98, 47), 10)
        assertArrayEquals(result, intArrayOf(4, 29, 34, 73, 47, 8, 11, 51, 98, 53))
    }

    @Test
    fun lexicographicallySmallestArray_9() {
        val result = lexicographicallySmallestArray(intArrayOf(4, 52, 38, 59, 71, 27, 31, 83, 88, 10), 14)
        assertArrayEquals(result, intArrayOf(4, 27, 31, 38, 52, 59, 71, 83, 88, 10))
    }
}