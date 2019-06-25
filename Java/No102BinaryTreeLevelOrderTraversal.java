import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
class No102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp = new ArrayList<>();
        TreeNode lastOfCurLevel = root;
        TreeNode lastOfNextLevel = root;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            temp.add(node.val);
            if(node.left!=null){
                lastOfNextLevel = node.left;
                q.offer(node.left);
            }
            if(node.right!=null){
                lastOfNextLevel = node.right;
                q.offer(node.right);
            }
            if(node == lastOfCurLevel){
                lastOfCurLevel = lastOfNextLevel;
                res.add(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }
}

