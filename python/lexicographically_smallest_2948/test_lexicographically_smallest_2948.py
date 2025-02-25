from unittest import TestCase

from python.lexicographically_smallest_2948.lexicographically_smallest_2948 import Solution


class TestSolution(TestCase):
    def test_lexicographically_smallest_array_1(self):
        result = Solution().lexicographicallySmallestArray([1, 5, 3, 9, 8], 2)
        self.assertEqual([1, 3, 5, 8, 9], result)

    def test_lexicographically_smallest_array_2(self):
        result = Solution().lexicographicallySmallestArray([1, 7, 6, 18, 2, 1], 3)
        self.assertEqual([1, 6, 7, 18, 1, 2], result)

    def test_lexicographically_smallest_array_3(self):
        result = Solution().lexicographicallySmallestArray([1, 7, 28, 19, 10], 3)
        self.assertEqual([1, 7, 28, 19, 10], result)

    def test_lexicographically_smallest_array_4(self):
        result = Solution().lexicographicallySmallestArray([1,60,34,84,62,56,39,76,49,38], 4)
        self.assertEqual([1,56,34,84,60,62,38,76,49,39], result)

    def test_lexicographically_smallest_array_5(self):
        result = Solution().lexicographicallySmallestArray([1,81,10,79,36,2,87,12,20,77], 7)
        self.assertEqual([1,77,10,79,36,2,81,12,20,87], result)

    def test_lexicographically_smallest_array_6(self):
        result = Solution().lexicographicallySmallestArray([81,79,87,77], 7)
        self.assertEqual([77,79,81,87], result)

    def test_lexicographically_smallest_array_7(self):
        result = Solution().lexicographicallySmallestArray([87,77], 10)
        self.assertEqual([77,87], result)

    def test_lexicographically_smallest_array_8(self):
        result = Solution().lexicographicallySmallestArray([4,34,29,73,51,11,8,53,98,47], 10)
        self.assertEqual([4,29,34,73,47,8,11,51,98,53], result)

    def test_lexicographically_smallest_array_9(self):
        result = Solution().lexicographicallySmallestArray([4,52,38,59,71,27,31,83,88,10], 14)
        self.assertEqual([4,27,31,38,52,59,71,83,88,10], result)