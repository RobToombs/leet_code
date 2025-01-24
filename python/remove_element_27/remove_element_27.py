from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        tracker: int = 0

        for num in nums:
            if num != val:
                nums[tracker] = num
                tracker += 1

        return tracker
