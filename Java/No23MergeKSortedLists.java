import java.util.PriorityQueue;
import java.util.Queue;
/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((ListNode n1, ListNode n2) -> { return n1.val - n2.val; });
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int len = lists.length;
        boolean init = false;
        while (len > 0) {
            if (!init) {
                init = true;
                for (ListNode l : lists) {
                    if (l != null) {
                        queue.add(l);
                    } else {
                        len--;
                    }
                }
            } else {
                ListNode top = queue.poll();
                p.next = top;
                p = p.next;
                if (top.next == null) {
                    len--;
                }else {
                    queue.add(top.next);
                }
            }
        }
        return dummy.next;
    }
}

