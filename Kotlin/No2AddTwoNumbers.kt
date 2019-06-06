class No2AddTwoNumbers {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var p = dummy
        var flag = 0
        var p1 = l1
        var p2 = l2
        while (p1 != null || p2 != null ||flag != 0) {
            val val1 = p1?.`val` ?: 0
            val val2 = p2?.`val` ?: 0
            val temp = val1 + val2 + flag
            flag = temp / 10
            p.next = ListNode(temp % 10)
            p = p.next
            p1 = p1?.next
            p2 = p2?.next
        }
        return dummy.next
    }
}