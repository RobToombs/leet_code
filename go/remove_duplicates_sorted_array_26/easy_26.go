package remove_duplicates_sorted_array_26

func removeDuplicates(nums []int) int {
	var current = nums[0]
	var length = 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != current {
			length++
			nums[length-1] = nums[i]
		}

		current = nums[i]
	}

	return length
}
