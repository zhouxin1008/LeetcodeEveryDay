import java.util.Stack;

/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        doReverseKGroup(dummy, k);
        return dummy.next;
    }
    private void doReverseKGroup(ListNode head, int k) {
        Stack<ListNode> s = new Stack<>();
        ListNode p = head;
        int copyK = k;
        while(k > 0) {
            p = p.next;
            if (p == null) return;
            s.push(p);
            k--;
        }
        ListNode tail = p.next;
        p = head;
        while(!s.isEmpty()) {
            p.next = s.pop();
            p = p.next;
        }
        p.next = tail;
        doReverseKGroup(p,copyK);

    }
}

