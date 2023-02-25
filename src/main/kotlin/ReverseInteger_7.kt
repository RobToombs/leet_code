import java.math.BigInteger

fun main() {
    println("${reverse(123)} = 321")
    println("${reverse(-123)} = -321")
    println("${reverse(120)} = 21")
    println("${reverse(1534236469)} = 0")
    println("${reverse(-2147483648)} = 0")
}

fun reverse(x: Int): Int {
    val negative = x < 0
    val reversed = "$x".replaceFirst("-","").reversed()

    val bigInteger = reversed.toBigInteger()
    return if(negative) {
        if(bigInteger.negate() <= BigInteger.valueOf(Integer.MIN_VALUE.toLong())) {
            0
        } else {
            -1 * reversed.toInt()
        }
    } else {
        if(bigInteger >= BigInteger.valueOf(Integer.MAX_VALUE.toLong())) {
            0
        } else {
            reversed.toInt()
        }
    }
}