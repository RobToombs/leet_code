import kotlin.math.max

fun main() {
    println("${maxProfit(intArrayOf(7,1,5,3,6,4))} = 5")
    println("${maxProfit(intArrayOf(7,6,4,3,1))} = 0")
}

fun maxProfit(prices: IntArray): Int {
    if(prices.isEmpty()) {
        return 0
    }

    var lowest = prices[0]
    var highest = prices[0]
    var maxProfit = 0
    for (index in 1 until prices.size) {
        val price = prices[index]
        if(price < lowest) {
            lowest = price
            highest = 0
        }
        else if(price >= highest) {
            highest = price
            maxProfit = max(maxProfit, highest - lowest)
        }
    }

    return maxProfit
}