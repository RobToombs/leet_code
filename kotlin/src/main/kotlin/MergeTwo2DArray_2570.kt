
fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
	var index1 = 0
	var index2 = 0
	while (index1 < nums1.size && index2 < nums2.size) {
		val firstNum = nums1[index1]
		val secondNum = nums2[index2]

		if(firstNum[0] == secondNum[0]) {
			result.add(intArrayOf(firstNum[0], firstNum[1] + secondNum[1]))
			index1++
			index2++
		}
		else if(firstNum[0] < secondNum[0]) {
			result.add(firstNum)
			index1++
		}
		else {
			result.add(secondNum)
			index2++
		}
	}

	if (index1 < nums1.size) {
		result.addAll(nums1.slice(index1 until nums1.size))
	}
	else if (index2 < nums2.size) {
		result.addAll(nums2.slice(index2 until nums2.size))
	}

	return result.toTypedArray()
}