import java.math.BigInteger

class ListNode(value: Int) {
    private var `val` = value
    var next: ListNode? = null

    fun add(n: Int) {
        var current = this
        while(current.next != null) {
            current = current.next!!
        }
        current.next = ListNode(n)
    }

    override fun toString(): String {
        var result = "[$`val`"

        var current = this
        while(current.next != null) {
            current = current.next!!
            result = "$result,${current.`val`}"
        }

        return "$result]"
    }

    fun toBigInt(): BigInteger {
        var result = BigInteger.valueOf(`val`.toLong())

        var current = this
        var multiplier = BigInteger.valueOf(10L)
        val ten = BigInteger.valueOf(10L)
        while(current.next != null) {
            current = current.next!!
            result += BigInteger.valueOf(current.`val`.toLong()) * multiplier
            multiplier *= ten
        }

        return result
    }

    companion object {
        fun toReversedNode(l: BigInteger): ListNode? {
            var result: ListNode? = null

            val number = "$l".toCharArray()
            for(i in number.size - 1 downTo 0) {
                val next = "${number[i]}".toInt()
                if(result == null) {
                    result = ListNode(next)
                }
                else {
                    result.add(next)
                }
            }

            return result
        }
    }
}

fun main() {
    var l1 = ListNode(2)
    l1.add(4)
    l1.add(3)

    var l2 = ListNode(5)
    l2.add(6)
    l2.add(4)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [7,0,8]")

    l1 = ListNode(2)
    l1.add(4)
    l1.add(9)

    l2 = ListNode(5)
    l2.add(6)
    l2.add(4)
    l2.add(9)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [7,0,4,0,1]")

    l1 = ListNode(9)
    l1.add(9)
    l1.add(9)
    l1.add(9)
    l1.add(9)
    l1.add(9)
    l1.add(9)

    l2 = ListNode(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [8,9,9,9,0,0,0,1]")

    l1 = ListNode(9)

    l2 = ListNode(1)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)
    l2.add(9)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [0,0,0,0,0,0,0,0,0,0,1]")

    l1 = ListNode(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)
    l1.add(1)

    l2 = ListNode(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)
    l2.add(1)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [2,2,2,2,2,2,2,2,2,2,2]")

    l1 = ListNode(1)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(0)
    l1.add(1)

    l2 = ListNode(5)
    l2.add(6)
    l2.add(4)

    println("${ListNode.toReversedNode(l1.toBigInt() + l2.toBigInt())} = [6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]")
}