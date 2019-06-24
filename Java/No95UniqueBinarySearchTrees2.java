import java.util.ArrayList;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
class No95UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<TreeNode>();
        if(n==0) return res[0];
        res[0].add(null);
        for(int i=1; i<=n; i++){
            res[i] = new ArrayList<TreeNode>();
            for(int j=0; j<i; j++){
                for(TreeNode left : res[j]){
                    for(TreeNode right : res[i-1-j]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = left;
                        node.right = clone(right, j+1);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }
    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}

