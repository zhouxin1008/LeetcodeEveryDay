/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
class No129SumRootToLeafNumbers {
    private int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int pre) {
        if(root==null) return;
        pre = pre*10 + root.val;
        if(root.left==null && root.right==null){
            res += pre;
        }
        dfs(root.left, pre);
        dfs(root.right, pre);
    }
}

