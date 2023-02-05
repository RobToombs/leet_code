import java.math.BigInteger

fun main() {
    extraLongFactorials(25)
}

fun extraLongFactorials(n: Int) {
    var result = BigInteger.valueOf(n.toLong())

    for(i in n - 1 downTo 2) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }

    println(result)
}