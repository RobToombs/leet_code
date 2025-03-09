from unittest import TestCase

from python.merge_two_2d_array_2570.merge_two_2d_array_2570 import Solution

class TestSolution(TestCase):
    def test_merge_arrays_1(self):
        nums1 = [[1,2],[2,3],[4,5]]
        nums2 = [[1,4],[3,2],[4,1]]
        result = Solution().mergeArrays(nums1, nums2)
        self.assertEqual([[1,6], [2,3], [3,2], [4,6]], result)

    def test_merge_arrays_2(self):
        nums1 = [[2,4],[3,6],[5,5]]
        nums2 = [[1,3],[4,3]]
        result = Solution().mergeArrays(nums1, nums2)
        self.assertEqual([[1,3], [2,4], [3,6], [4,3], [5,5]], result)
