package merge_two_2d_array_2570

func mergeArrays(nums1 [][]int, nums2 [][]int) [][]int {
	result := [][]int{}
	index1 := 0
	index2 := 0

	for index1 < len(nums1) && index2 < len(nums2) {
		firstNum := nums1[index1]
		secondNum := nums2[index2]

		if firstNum[0] == secondNum[0] {
			result = append(result, []int{firstNum[0], firstNum[1] + secondNum[1]})
			index1++
			index2++
		} else if firstNum[0] < secondNum[0] {
			result = append(result, firstNum)
			index1++
		} else {
			result = append(result, secondNum)
			index2++
		}
	}

	if index1 < len(nums1) {
		result = append(result, nums1[index1:]...)
	} else if index2 < len(nums2) {
		result = append(result, nums2[index2:]...)
	}

	return result
}
