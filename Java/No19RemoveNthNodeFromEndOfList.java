class No19RemoveNthNodeFromEndOfList {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return head;
    ListNode fast = head;
    ListNode slow = head;
    for(int i=1; i<=n; i++) {
      fast = fast.next;
    }
    if(fast == null) return head.next;
    while(fast.next!=null){
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}