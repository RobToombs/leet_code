import java.util.*

fun main() {
    println("${permute(intArrayOf(5,4,6,2))}")
    println("${permute(intArrayOf(1,2,3))}")
    println("${permute(intArrayOf(0,1))}")
    println("${permute(intArrayOf(1))}")
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    permuteHelper(result, Stack<Int>(), nums)
    return result
}

private fun permuteHelper(result: MutableList<List<Int>>, temp: Stack<Int>, nums: IntArray) {
    if (temp.size == nums.size) {
        result.add(temp.toList())
    } else {
        for (num in nums) {
            if (!temp.contains(num)) {
                temp.push(num)
                permuteHelper(result, temp, nums)
                temp.pop()
            }
        }
    }
}
