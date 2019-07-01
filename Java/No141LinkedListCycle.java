
/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
public class No141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode p1 = head.next;
        ListNode p2 = head;
        while(p1!=null && p1!=p2){
            p1 = p1.next==null ? null : p1.next.next;
            p2 = p2.next;
        }
        if(p1==p2) return true;
        return false;
    }
}

