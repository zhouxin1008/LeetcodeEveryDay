/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head != null) {
            doSwapPairs(dummy);
        }
        return dummy.next;
    }
    private void doSwapPairs(ListNode head) {
        ListNode n1 = head.next;
        if (n1 != null) {
            ListNode n2 = n1.next;
            if (n2 == null) return;
            ListNode tail = n2.next;
            head.next = n2;
            n2.next = n1;
            n1.next = tail;
            doSwapPairs(n1);
        }
    }
}

