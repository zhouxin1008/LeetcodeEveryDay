import java.util.Stack;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
class NO230KthSmallestElementIn_A_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(!s.isEmpty() || p!=null){
            while(p!=null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            k--;
            if(k==0) return p.val;
            p = p.right;
        }
        return -1;
    }
}

