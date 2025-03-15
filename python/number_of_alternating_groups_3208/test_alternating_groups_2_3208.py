from unittest import TestCase

from python.number_of_alternating_groups_3208.alternating_groups_2_3208 import Solution


class TestSolution(TestCase):
    def test_number_of_alternating_groups_1(self):
        colors = [0,1,0,1,0]
        k = 3
        result = Solution().numberOfAlternatingGroups(colors, k)
        self.assertEqual(3, result)

    def test_number_of_alternating_groups_2(self):
        colors = [0,1,0,0,1,0,1]
        k = 6
        result = Solution().numberOfAlternatingGroups(colors, k)
        self.assertEqual(2, result)

    def test_number_of_alternating_groups_3(self):
        colors = [1,1,0,1]
        k = 4
        result = Solution().numberOfAlternatingGroups(colors, k)
        self.assertEqual(0, result)
