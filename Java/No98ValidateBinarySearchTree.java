/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
class No98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, Integer min, Integer max){
        if(root==null) return true;
        if((max!=null && root.val>=max) || (min!=null && root.val<=min)) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}

