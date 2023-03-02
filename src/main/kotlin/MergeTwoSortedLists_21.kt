fun main() {
    val l1 = ListNode(1)
    l1.add(2)
    l1.add(4)

    val l2 = ListNode(1)
    l2.add(3)
    l2.add(4)

    println("${mergeTwoLists(l1, l2)} = [1,1,2,3,4,4]")
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null) {
        return list2
    }

    if(list2 == null) {
        return list1
    }

    var head1 = list1
    var head2 = list2
    val result = if(list1.`val` <= list2.`val`) {
        head1 = list1.next
        ListNode(list1.`val`)
    } else {
        head2 = list2.next
        ListNode(list2.`val`)
    }

    var resultTail: ListNode? = result
    while(head1 != null || head2 != null) {
        if(head1 == null) {
            resultTail!!.next = head2
            break
        }
        else if(head2 == null) {
            resultTail!!.next = head1
            break
        }
        else if(head1.`val` <= head2.`val`) {
            resultTail!!.next = ListNode(head1.`val`)
            resultTail = resultTail.next
            head1 = head1.next
        } else {
            resultTail!!.next = ListNode(head2.`val`)
            resultTail = resultTail.next
            head2 = head2.next
        }
    }

    return result
}