from typing import List
from unittest import TestCase

from python.remove_element_27.remove_element_27 import Solution


class TestSolution(TestCase):

    def test_remove_element_1(self):
        input_list: List[int] = [3, 2, 2, 3]
        result = Solution().removeElement(input_list, 3)
        self.assertEqual(result, 2)
        self.assertEqual([2, 2, 2, 3], input_list)

    def test_remove_element_2(self):
        input_list: List[int] = [0, 1, 2, 2, 3, 0, 4, 2]
        result = Solution().removeElement(input_list, 2)
        self.assertEqual(result, 5)
        self.assertEqual([0, 1, 3, 0, 4, 0, 4, 2], input_list)
