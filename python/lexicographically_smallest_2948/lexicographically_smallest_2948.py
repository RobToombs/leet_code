from typing import List


class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        # Create a sorted list of elements by value while maintaining index
        # [1, 5, 3, 9, 8]
        # [(1,0), (3,2), (5,1), (8,4), (9,5)]
        els = list(sorted([(nums[i], i) for i in range(len(nums))]))

        # Create groupings of values where all values in the group are within the limit
        # [(1,0), (3,2), (5,1), (8,4), (9,5)]
        # [
        #   [(1, 0), (3, 2), (5, 1)],
        #   [(8, 4), (9, 3)]
        # ]
        part = [els[0]]
        parts = []
        for i in range(1, len(els)):
            if els[i][0] - els[i-1][0] <= limit:
                part.append(els[i])
            else:
                parts.append(part)
                part = [els[i]]
        parts.append(part)

        # Initialize a result of the same input nums length with 'empty' values
        # [1, 5, 3, 9, 8]
        # [0, 0, 0, 0, 0]
        result = [0 for _ in range(len(nums))]

        # Iterate over the groupings, creating two lists sorted by index and value, ex:
        # 1.
        # [(1, 0), (3, 2), (5, 1)]
        # [0, 1, 2]
        # [1, 3, 5]
        # 2.
        # [(8, 4), (9, 3)]
        # [3, 4]
        # [8, 9]
        for part in parts:
            indexes = sorted(map(lambda x:x[1], part))
            values = sorted(map(lambda x:x[0], part))
            # Iterate over the ordered indexes assigning the associated ordered value to the result index
            # [1,0,0,0,0] -> [1,3,0,0,0] -> [1,3,5,0,0] -> [1,3,5,8,0] -> [1,3,5,8,9]
            for ii in range(len(indexes)):
                result[indexes[ii]] = values[ii]

        return result


