import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val input: Array<IntArray> = arrayOf(
        intArrayOf(1,0,1),
        intArrayOf(0,0,0),
        intArrayOf(1,0,1)
    )

    println(maxDistance(input))
}
fun maxDistance(grid: Array<IntArray>): Int {
    var result = -1

    if(grid.isNotEmpty()) {
        val water = mutableListOf<Pair<Int, Int>>()
        val land = mutableListOf<Pair<Int, Int>>()

        val width = grid[0].size
        val height = grid.size

        for (y in 0 until height) {
            for (x in 0 until width) {
                val item = grid[y][x]
                if (item == 0) {
                    water.add(Pair(y, x))
                }
                else if(item == 1) {
                    land.add(Pair(y, x))
                }
            }
        }

        for(w in 0 until water.size) {
            var minDistance = -1
            for(l in 0 until land.size) {
                val distance = manhattanDistance(water[w], land[l])

                minDistance =
                    if(minDistance == -1) {
                        distance
                    } else {
                        min(minDistance, distance)
                    }
            }

            result = max(minDistance, result)
        }
    }

    return result
}

fun manhattanDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return abs(p1.first - p2.first) + abs(p1.second - p2.second)
}