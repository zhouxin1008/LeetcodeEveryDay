/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode fast = head, slow = head, mid = null, reverse = null;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) mid = slow;
        else mid = slow.next;
        reverse = reverse(mid);
        while(reverse!=null && head!=null){
            if(reverse.val!=head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

