
fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
	var result = 0
	var counter = k - 1
	var previousColor = colors[0]
	var currentColor: Int
	for (i in 1 until colors.size + k - 1) {
		currentColor = colors[i % colors.size]
		if (currentColor != previousColor) {
			counter--
		} else {
			counter = k - 1
		}

		previousColor = currentColor

		if (counter <= 0) {
			result++
		}
	}

	return result
}