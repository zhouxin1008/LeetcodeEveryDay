/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No148SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(midNext);
        return merge(n1, n2);
    }
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(n1!=null && n2!=null){
            if(n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            }else{
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        p.next = n1==null ? n2 : n1;
        return dummy.next;
    }
    private ListNode getMid(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        return pre;
    }
}

