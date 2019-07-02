import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
class No144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while(node != null){
            res.add(node.val);
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            node = s.isEmpty() ? null : s.pop();
        }
        return res;
    }
}

