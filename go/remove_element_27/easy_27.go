package remove_element_27

func removeElement(nums []int, val int) int {
	tracker := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != val {
			nums[tracker] = nums[i]
			tracker++
		}
	}

	return tracker
}
