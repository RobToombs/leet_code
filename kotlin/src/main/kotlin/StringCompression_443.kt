fun main() {
    println("${compress(charArrayOf('a','a','b','b','c','c','c'))} == 6")
    println("${compress(charArrayOf('a'))} == 1")
    println("${compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b'))} == 4")
}

fun compress(chars: CharArray): Int {
    if(chars.isEmpty()) {
        return 0
    }

    var compressed = ""
    var count = 0
    var currentLetter: Char = chars[0]
    for(letter in chars) {
        if(currentLetter != letter) {
            compressed = if(count > 1) {
                "$compressed$currentLetter$count"
            } else {
                "$compressed$currentLetter"
            }

            currentLetter = letter
            count = 1
        }
        else {
            count++
        }
    }

    compressed = if(count > 1) {
        "$compressed$currentLetter$count"
    } else {
        "$compressed$currentLetter"
    }

    for((index, letter) in compressed.withIndex()) {
        chars[index] = letter
    }

    return compressed.length
}