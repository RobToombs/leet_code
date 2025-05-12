import kotlin.math.abs

fun minCapability(nums: IntArray, k: Int): Int {
	val result = mutableListOf<Int>()
	val current = mutableListOf<Int>()

	fun backtrack(lastIndex: Int) {
		if (current.size == k) {
			result.add(current.max())
			return
		}

		for (i in nums.indices) {
			// Skip adjacent indices or repeated indices in the current permutation
			if (current.isNotEmpty() && abs(i - lastIndex) == 1) continue // Skip adjacent index

			// Choose the number
			current.add(nums[i])

			// Backtrack with the current index as the lastIndex
			backtrack(i)

			// Undo the choice
			current.removeAt(current.size - 1)
		}
	}

	// Start the backtracking loop with an invalid index (-1)
	backtrack(-1)
	return result.minOrNull() ?: 0
}