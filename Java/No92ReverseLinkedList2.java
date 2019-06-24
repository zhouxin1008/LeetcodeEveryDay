
/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No92ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m==n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode reverseHead = dummy;
        ListNode mNode = dummy;
        while(m>0){
            reverseHead = mNode;
            mNode = mNode.next;
            m--;
        }
        ListNode nNode = dummy;
        while(n>0){
            nNode = nNode.next;
            n--;
        }
        ListNode p = mNode.next;
        while(p!=nNode){
            ListNode next = p.next;
            p.next = reverseHead.next;
            reverseHead.next = p;
            p = next;
        }
        mNode.next = nNode.next;
        nNode.next = reverseHead.next;
        reverseHead.next = nNode;
        return dummy.next;
    }
}

