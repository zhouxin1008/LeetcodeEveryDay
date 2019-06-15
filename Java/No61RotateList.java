/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = count(head);
        if (len==0) return head;
        k = k % len;
        if (k==0) return head;
        ListNode dummy = new ListNode(0);
        ListNode p1 = head ,p2 = head;
        while(k > 0) {
            k--;
            p1 = p1.next;
        }
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        dummy.next = p2.next;
        p2.next = null;
        p1.next = head;
        return dummy.next;
    }

    private int count(ListNode head) {
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}

