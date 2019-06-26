/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
class No110BalancedBinaryTree {
    class Unit{
        int dep;
        boolean balanced;
        public Unit(int dep, boolean balanced){
            this.dep = dep;
            this.balanced = balanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return doSearch(root).balanced;
    }

    public Unit doSearch(TreeNode root) {
        if(root == null) return new Unit(0, true);
        Unit left = doSearch(root.left);
        if(!left.balanced) return new Unit(0, false);
        Unit right = doSearch(root.right);
        if(!right.balanced) return new Unit(0, false);
        return new Unit(1+Math.max(left.dep, right.dep), Math.abs(left.dep - right.dep) <= 1);
    }
}

