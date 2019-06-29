
/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
class No124BinaryTreeMaximumPathSum {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        getMax(root);
        return res;
    }
    private int getMax(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int max = root.val;
        if(left > 0) max += left;
        if(right > 0) max += right;
        res = Math.max(res, max);
        if(left<=0 && right<=0){
            return root.val;
        }else{
            return Math.max(left, right) + root.val;
        }
    }
}

