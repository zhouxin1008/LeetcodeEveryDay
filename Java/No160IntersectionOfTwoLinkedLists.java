
/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class No160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if(lenA > lenB) {
            int diff = lenA -lenB;
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        }
        if(lenB > lenA) {
            int diff = lenB -lenA;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        while(headA!=headB) {
            if(headA==null || headB==null){
                return null;
            }
            headA = headA.next; 
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}

