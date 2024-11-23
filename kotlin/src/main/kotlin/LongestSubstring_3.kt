import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("abcabcbb") == 3)
    println(lengthOfLongestSubstring("bbbbb") == 1)
    println(lengthOfLongestSubstring("pwwkew") == 3)
    println(lengthOfLongestSubstring(" ") == 1)
    println(lengthOfLongestSubstring("cdd") == 2)
    println(lengthOfLongestSubstring("abba") == 2)
    println(lengthOfLongestSubstring("dvdf") == 3)
    println(lengthOfLongestSubstring("ohomm") == 3)
}

fun lengthOfLongestSubstring(s: String): Int {
    var charToIndexMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    var lastRepeatIndex = 0

    for((index, char) in s.toCharArray().withIndex()) {
        // If the max length is at the beginning of the string
        if(lastRepeatIndex == 0) {
            maxLength = index
        }

        if (charToIndexMap.contains(char)) {
            val previousIndex = charToIndexMap.getValue(char)
            maxLength = max(maxLength, charToIndexMap.size)
            lastRepeatIndex = index

            // Clear out all indices prior to the first repeated index since we know that anything prior
            // cannot be part of a new max length
            charToIndexMap = charToIndexMap
                .filter { entry -> entry.value > previousIndex }
                .toMutableMap()
        }

        charToIndexMap[char] = index
    }

    // If the max length is at the end of the string, simply use the size of our char to index map
    // because we know that this constitutes the size of the non-repeated string at the end of the input
    maxLength = max(maxLength, charToIndexMap.size)

    return maxLength
}