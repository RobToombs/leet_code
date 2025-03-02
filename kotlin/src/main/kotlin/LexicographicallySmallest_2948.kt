
data class Item(val value: Int, val index: Int)

fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
    // Create a sorted list of elements by value while maintaining index
    val items = nums.mapIndexed { index, value -> Item(value, index) }.toMutableList()
    items.sortBy { it.value }

    // Create groupings of values where all values in the group are within the limit
    var part = mutableListOf(items[0])
    val parts = mutableListOf<List<Item>>()
    for (i in 1 until items.size) {
        if (items[i].value - items[i-1].value <= limit) {
            part.add(items[i])
        } else {
            parts.add(part)
            part = mutableListOf(items[i])
        }
    }
    parts.add(part)

    // Initialize a result of the same input nums length with 'empty' values
    val result = IntArray(nums.size) { 0 }

    // Iterate over the groupings, creating two lists sorted by index and value
    for (p in parts) {
        val sortedByValue = p.sortedBy { it.value }
        val sortedByIndex = p.sortedBy { it.index }

        // Iterate over the ordered indexes assigning the associated ordered value to the result index
        for (i in sortedByIndex.indices) {
            result[sortedByIndex[i].index] = sortedByValue[i].value
        }
    }

    return result
}