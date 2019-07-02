
/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class No142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        int step = 0;
        ListNode p1 = head;
        ListNode p2 = head;
        while(step==0 || (p1!=null && p1!=p2)) {
            p1 = p1.next!=null ? p1.next.next : null;
            p2 = p2.next; 
            step++;
        }
        if(p1==null) return null;
        p1 = head;
        p2 = head;
        while(step!=0){
            p1 = p1.next;
            step--;
        }
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

