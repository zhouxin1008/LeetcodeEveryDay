import java.util.Queue;

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
class No114FlattenBinaryTreeToLinkedList {
    private Queue<TreeNode> q;
    public void flatten(TreeNode root) {
        q = new LinkedList<>();
        preOrder(root);
        TreeNode pre = null;
        TreeNode cur = null;
        while(!q.isEmpty()) {
            cur = q.poll();
            if(pre!=null) {
                pre.left = null;
                pre.right = cur;
            }
            pre = cur;
        }
        if(cur!=null){
            cur.left = null;
            cur.right = null;
        }
    }
    private void preOrder(TreeNode root) {
        if(root==null) return;
        q.offer(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}

