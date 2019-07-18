/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head, even = head.next, p1 = head, p2 = head.next, p = head.next.next;
        boolean isOdd = true;
        while(p!=null){
            if(isOdd) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            isOdd = !isOdd;
            p = p.next;
        }
        p1.next = even;
        p2.next = null;
        return odd;
    }
}

