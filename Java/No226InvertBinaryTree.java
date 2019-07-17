/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
class No226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
        }
        return root;
    }
}

