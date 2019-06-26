import java.util.Arrays;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int length = preorder.length;
        return buildTree(preorder, 0, length-1, inorder, 0, length-1);
    }
    public TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int q) {
        if(i>j || p>q) return null;
        TreeNode root = new TreeNode(preorder[i]);
        if(i==j) return root;
        int index = findNode(inorder, preorder[i]);
        root.left = index==p ? null : buildTree(preorder, i+1, i+index-p, inorder, p, index-1);
        root.right = index==q ? null : buildTree(preorder, i+index-p+1, j, inorder, index+1, q);
        return root;
    }
    private int findNode(int[] array, int target){
        for(int i=0; i<array.length; i++){
            if(array[i]==target) return i;
        }
        return 0;
    }
}

