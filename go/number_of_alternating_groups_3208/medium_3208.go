package number_of_alternating_groups_3208

func numberOfAlternatingGroups(colors []int, k int) int {
	result := 0
	counter := k - 1
	previousColor := colors[0]
	var currentColor int
	for i := 1; i < len(colors)+k-1; i++ {
		currentColor = colors[i%len(colors)]
		if colors[i%len(colors)] != previousColor {
			counter--
		} else {
			counter = k - 1
		}

		previousColor = currentColor

		if counter <= 0 {
			result++
		}
	}

	return result
}
