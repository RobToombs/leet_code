from typing import List


class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        result: List[List[int]] = []
        index1: int = 0
        index2: int = 0

        while index1 < len(nums1) and index2 < len(nums2):
            first_num: List[int] = nums1[index1]
            second_num: List[int] = nums2[index2]

            if first_num[0] == second_num[0]:
                result.append([first_num[0], first_num[1] + second_num[1]])
                index1 += 1
                index2 += 1
            elif first_num[0] < second_num[0]:
                result.append(first_num)
                index1 += 1
            else:
                result.append(second_num)
                index2 += 1

        if index1 < len(nums1):
            result.extend(nums1[index1::])
        elif index2 < len(nums2):
            result.extend(nums2[index2::])

        return result
        