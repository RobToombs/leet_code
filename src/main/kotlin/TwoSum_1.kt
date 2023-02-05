
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

fun main() {
    val r1 = twoSum(intArrayOf(2,7,11,15), 9)
    println(r1.asList()) // [0,1]

    val r2 = twoSum(intArrayOf(3,2,4), 6)
    println(r2.asList()) // [1,2]

    val r3 = twoSum(intArrayOf(3,3), 6)
    println(r3.asList()) // [0,1]
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numToIndexMap = hashMapOf<Int, MutableList<Int>>()
    for(i in nums.indices) {
        val num = nums[i]
        val indices = numToIndexMap.getOrPut(num) { mutableListOf() }
        indices.add(i)
        numToIndexMap[num] = indices
    }

    for (i in nums.indices) {
        val num = nums[i]
        val pair = target - num
        if(numToIndexMap.containsKey(pair)) {
            val index = numToIndexMap[pair]?.last()
            if(index != i) {
                return intArrayOf(i, index!!)
            }
        }
    }

    return intArrayOf()
}