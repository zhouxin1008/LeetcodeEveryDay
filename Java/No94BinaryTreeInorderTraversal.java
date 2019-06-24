import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
class No94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode p = root;
        while(p!=null) {
            s.push(p);
            p = p.left;
        }
        while (!s.isEmpty()) {
            p = s.pop();
            res.add(p.val);
            p = p.right;
            while(p!=null){
                s.push(p);
                p = p.left;
            }
        }
        return res;
    }
}

