/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
class No106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        int length = inorder.length;
        return buildTree(inorder, 0, length-1, postorder, 0, length-1);
    }
    public TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int q) {
        if(i>j || p>q) return null;
        TreeNode root = new TreeNode(postorder[q]);
        if(i==j) return root;
        int index = findNode(inorder, postorder[q]);
        root.left = index==i ? null : buildTree(inorder, i, index-1, postorder, p, p+index-i-1);
        root.right = index==j ? null : buildTree(inorder, index+1, j, postorder, p+index-i, q-1);
        return root;
    }
    private int findNode(int[] array, int target){
        for(int i=0; i<array.length; i++){
            if(array[i]==target) return i;
        }
        return 0;
    }
}

