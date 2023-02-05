
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/

fun main() {
    val r1 = findAnagrams("cbaebabacd", "abc")
    println(r1) // [0, 6]

    val r2 = findAnagrams("abab", "ab")
    println(r2) // [0, 1, 2]
}

fun findAnagrams(s: String, p: String): List<Int> {
    val result = mutableListOf<Int>()

    val anagram = createMap(p)
    for(i in 0 .. s.length - p.length) {
        val slice = s.substring(i, i + p.length)
        if(anagram == createMap(slice)) {
            result.add(i)
        }
    }

    return result
}

fun createMap(p: String): HashMap<Char, Int> {
    val result = hashMapOf<Char, Int>()

    p.forEach {
        val count = result.getOrPut(it) { 0 }
        result[it] = count + 1
    }

    return result
}