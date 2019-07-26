import java.util.ArrayList;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
class No257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        dfs(root, "", res);
        return res;
    }
    private void dfs(TreeNode root, String s, List<String> res){
        s = (s.isEmpty() ? s : s + "->") + root.val;
        if(root.left==null && root.right==null){
            res.add(s);
            return;
        }
        if(root.left!=null) dfs(root.left, s , res);
        if(root.right!=null) dfs(root.right, s , res);
    }
}

