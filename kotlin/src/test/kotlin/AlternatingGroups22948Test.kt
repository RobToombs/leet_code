import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AlternatingGroups22948Test {

    @Test
    fun numberOfAlternatingGroups_1() {
        val result = numberOfAlternatingGroups(intArrayOf(0,1,0,1,0), 3)
        assertEquals(3, result)
    }

    @Test
    fun numberOfAlternatingGroups_2() {
        val result = numberOfAlternatingGroups(intArrayOf(0,1,0,0,1,0,1), 6)
        assertEquals(2, result)
    }

    @Test
    fun numberOfAlternatingGroups_3() {
        val result = numberOfAlternatingGroups(intArrayOf(1,1,0,1), 4)
        assertEquals(0, result)
    }
}