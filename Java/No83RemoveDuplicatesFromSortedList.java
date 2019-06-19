
/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        boolean attachHead = false;
        while(head != null) {
            if(!attachHead || p.val != head.val) {
                p.next = head;
                p = p.next;
                attachHead = true;
            }
            head=head.next;
        }
        p.next = null;
        return dummy.next;
    }
}

