
fun main() {
    minMaxSum(arrayOf(1, 2, 3, 4, 5))
}

fun minMaxSum(arr: Array<Int>) {
    val longArray = arr.map { it.toLong() }
    var max = 0L
    var min = 0L

    for(i in longArray.indices) {
        val sum = longArray.sum() - arr[i]
        if(max == 0L || sum >= max) {
            max = sum
        }

        if(min == 0L || sum <= min) {
            min = sum
        }
    }

    println("$min $max")
}