
fun main() {
    val height = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)

    var maxLeft = 0
    var maxRight = 0
    var maxRightIndex = 0
    var total = 0
    for((index, column) in height.withIndex()) {
        // Find max left
        if(column > maxLeft) {
            maxLeft = column
        }

        // Retain max right
        if(index >= maxRightIndex) {
            val (rMax, rIndex) = maxRight(index, height)
            maxRight = rMax
            maxRightIndex = rIndex
        }

        if(maxLeft > column && maxRight > column) {
            total += (maxLeft.coerceAtMost(maxRight) - column)
        }
    }

    println(total)
}

fun maxRight(index: Int, height: IntArray): Pair<Int, Int> {
    var maxRight = 0
    var maxRightIndex = 0
    for(i in index until height.size) {
        if(height[i] > maxRight) {
            maxRight = height[i]
            maxRightIndex = i
        }
    }
    return Pair(maxRight, maxRightIndex)
}