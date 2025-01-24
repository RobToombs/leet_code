fun main() {
    println("${removeElement(intArrayOf(3,2,2,3), 3) == 2}")
//    println("${removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2) == 5}")
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var tracker: Int = 0

    for (num in nums) {
        if (num != `val`) {
            nums[tracker] = num
            tracker++
        }
    }

    return tracker
}