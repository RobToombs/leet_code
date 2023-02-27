
fun main() {
    /*
          r o s
      [ 0 1 2 3 ]
    h [ 1 1 2 3 ]
    o [ 2 2 1 2 ]
    r [ 3 2 2 2 ]
    s [ 4 3 3 2 ]
    e [ 5 4 4 3 ]
     */
    println("${minDistance("horse", "ros")} = 3")

    /*
          e x e c u t i o n
      [ 0 1 2 3 4 5 6 7 8 9 ]
    i [ 1 1 2 3 4 5 6 6 7 8 ]
    n [ 2 2 2 3 4 5 6 7 7 7 ]
    t [ 3 3 3 3 4 5 5 6 7 8 ]
    e [ 4 3 4 3 4 5 6 6 7 8 ]
    n [ 5 4 4 4 4 5 6 7 7 7 ]
    t [ 6 5 5 5 5 5 5 6 7 8 ]
    i [ 7 6 6 6 6 6 6 5 6 7 ]
    o [ 8 7 7 7 7 7 7 6 5 6 ]
    n [ 9 8 8 8 8 8 8 7 6 5 ]
     */
    println("${minDistance("intention", "execution")} = 5")
}

fun minDistance(word1: String, word2: String): Int {
    if(word1 == word2) {
        return 0
    }

    if(word1.isBlank()) {
        return word2.length
    }

    if(word2.isBlank()) {
        return word1.length
    }

    /* Populate a 2D array where the Y axis represents word1 and the X axis represents word2

            " e x e c u t i o n
        " [ 0 1 2 3 4 5 6 7 8 9 ]
        i [ 1 0 0 0 0 0 0 0 0 0 ]
        n [ 2 0 0 0 0 0 0 0 0 0 ]
        t [ 3 0 0 0 0 0 0 0 0 0 ]
        e [ 4 0 0 0 0 0 0 0 0 0 ]
        n [ 5 0 0 0 0 0 0 0 0 0 ]
        t [ 6 0 0 0 0 0 0 0 0 0 ]
        i [ 7 0 0 0 0 0 0 0 0 0 ]
        o [ 8 0 0 0 0 0 0 0 0 0 ]
        n [ 9 0 0 0 0 0 0 0 0 0 ]

        The base array represents the minimum edit distance between the first 'i' letters in
        word1 and the first 'j' letters in word2. The [0,0] location indicates the minimum
        distance to an empty string. I.e., if word1 = "int" and word2 = "", it would take 3
        deletes to convert word1 to word2.
     */
    val array = Array(word1.length + 1) { IntArray( word2.length + 1) }
    array[0][0] = 0
    for(i in word1.indices) {
        array[i+1][0] = i+1
    }

    for(j in word2.indices) {
        array[0][j+1] = j+1
    }

    /*
    Iterate over both words comparing letters. The 'i' offset and 'j' offset are
    necessary because the array is [word1.length + 1] X [word2.length + 1]. I.e., we
    don't need to account for the 0 index column or 0 index row.
     */
    for((i, l1) in word1.withIndex()) {
        val iOff = i + 1
        for((j, l2) in word2.withIndex()) {
            val jOff = j + 1
            /* If the letters are the same, mark the min difference to be equal to the
               array[i-1][j-1] location since no edit is needed. Check out the completed
               example tables above in 'main' for reference.
            */
            if(l1 == l2) {
                array[iOff][jOff] = array[iOff-1][jOff-1]
            }
            /* If the letters are not the same, compare the possible previous minimum edit
            values and take the lowest number. Add 1 to this value, and add it to the table.
             */
            else {
                array[iOff][jOff] = 1 + minOf(array[iOff-1][jOff-1], array[iOff][jOff-1], array[iOff-1][jOff])
            }
        }
    }

    // The final minimum edit value is the final array position
    return array[word1.length][word2.length]
}