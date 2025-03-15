from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        result = 0
        counter = k -1
        previous_color: int = colors[0]
        current_color: int
        for i in range(1, len(colors) + k - 1):
            current_color = colors[i % len(colors)]
            if current_color != previous_color:
                counter -= 1
            else:
                counter = k - 1

            previous_color = current_color
            if counter <= 0:
                result += 1

        return result

