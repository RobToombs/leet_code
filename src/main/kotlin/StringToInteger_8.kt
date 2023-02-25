import java.math.BigInteger

fun main() {
    println("${myAtoi("42")} = 42")
    println("${myAtoi("   -42")} = -42")
    println("${myAtoi("4193 with words")} = 4193")
    println("${myAtoi("-91283472332")} = -2147483648")
    println("${myAtoi("+1")} = 1")
    println("${myAtoi("-2147483648")} = 1")
    println("${myAtoi("20000000000000000000")} = 1")
}

fun myAtoi(s: String): Int {
    var trimmed = s.trim()

    if(trimmed.isEmpty()) {
        return 0
    }

    val sign = trimmed[0]
    var negative = false
    if(sign == '-' || sign == '+') {
        negative = sign == '-'
        trimmed = trimmed.drop(1) // Drop Sign
    }
    trimmed = trimmed.replaceFirst("^0+(?!$)", "") // Remove Leading Zeroes

    var integerStr = ""
    for(element in trimmed) {
        if (element.isDigit()) {
            integerStr = "$integerStr$element"
        } else {
            break
        }
    }

    if(integerStr.isEmpty()) {
        return 0
    }

    val bigInteger = integerStr.toBigInteger()
    return if(negative) {
        if(bigInteger.negate() <= BigInteger.valueOf(Integer.MIN_VALUE.toLong())) {
            Int.MIN_VALUE
        } else {
            -1 * integerStr.toInt()
        }
    } else {
        if(bigInteger >= BigInteger.valueOf(Integer.MAX_VALUE.toLong())) {
            Integer.MAX_VALUE
        } else {
            integerStr.toInt()
        }
    }
}