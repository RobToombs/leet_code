import java.math.BigInteger

class ListNode(value: Int) {
    var `val` = value
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

    /**
    Knowing the provided ListNodes are in 'reverse order' where
    the first node represents the ones position, build up the BigInt
    multiply each 'n' by 10^n before adding it to the sum.

    Ex. input = [9,1,3,4]
    9 * 10^0 = 9
    1 * 10^1 = 10
    3 * 10^2 = 300
    4 * 10^3 = 4000

    4000 + 300 + 10 + 9 = 4319
     */
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
        /**
        Take the given BitInteger, convert it to a character array, and
        iterate through it backwards (since the head of the ListNode is the
        last digit of the number) building up a new ListNode

        Ex. input = 4319
        [4,3,1,9]
        ListNode(9)
        ListNode(9).next = ListNode(1)
        ListNode(9).next = ListNode(1).next = ListNode(3)
        ListNode(9).next = ListNode(1).next = ListNode(3).next = ListNode(4)
         */
        fun toListNode(l: BigInteger): ListNode? {
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