import kotlin.math.abs

fun main() {
    val input = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1)
    val indexed = input.mapIndexed {index, value -> Pair(index, value.toLong()) }.toMutableList()
    val slices = mutableSetOf<List<Pair<Int, Long>>>()
    numberOfArithmeticSlices(indexed, slices)
    println(slices.size)
}

fun numberOfArithmeticSlices(nums: MutableList<Pair<Int, Long>>, slices: MutableSet<List<Pair<Int, Long>>>) {
    if(nums.size >= 3) {
        if (validSequence(nums)) {
            slices.add(nums)
        }

        for (index in nums.indices) {
            val clone = mutableListOf<Pair<Int, Long>>().apply { addAll(nums) }
            clone.removeAt(index)
            numberOfArithmeticSlices(clone, slices)
        }
    }
}

fun validSequence(nums: MutableList<Pair<Int, Long>>): Boolean {
    var diff = abs(nums[0].second - nums[1].second)
    if(nums[0].second > nums[1].second) {
        diff *= -1
    }

    for(index in 1 until nums.size - 1) {
        if(nums[index].second + diff != nums[index+1].second) {
            return false
        }
    }

    return true
}