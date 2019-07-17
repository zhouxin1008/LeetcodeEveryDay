/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
class No222CountCompleteTreeNodes {
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if(h <= 1) return h;
        if(h-1 == getHeight(root.right)){
            return (1 << h-1) + countNodes(root.right);
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}

