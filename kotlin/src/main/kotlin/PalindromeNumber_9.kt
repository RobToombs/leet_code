fun main() {
    println("${isPalindrome(121)} = true")
    println("${isPalindrome(-121)} = false")
    println("${isPalindrome(10)} = false")
}

fun isPalindrome(x: Int): Boolean {
    val str = "$x"
    for(i in 0 until str.length / 2) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }

    return true
}