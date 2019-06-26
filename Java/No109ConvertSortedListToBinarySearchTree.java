/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class No109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode p, ListNode q) {
        if(p==q) return null;
        if(p.next == q) return new TreeNode(p.val);
        if(p.next.next == q) {
            TreeNode root = new TreeNode(p.val);
            root.right = new TreeNode(p.next.val);
            return root;
        }
        ListNode mid = getMid(p,q);
        TreeNode root = new TreeNode(mid.val);
        root.left =  sortedListToBST(p, mid);
        root.right =  sortedListToBST(mid.next, q);
        return root;
    }

    private ListNode getMid(ListNode p, ListNode q) {
        ListNode slow, fast;
        slow = fast = p;
        while(fast.next!=q && fast.next.next!=q){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

