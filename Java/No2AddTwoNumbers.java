class No2AddTwoNumbers {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode p = dummy;
      int flag = 0;
      while(l1!=null || l2!=null || flag != 0 ) {
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int temp = val1 + val2 + flag;
        flag = temp / 10;
        p.next = new ListNode(temp % 10);
        p = p.next;
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
      }
      return dummy.next;
  }
}