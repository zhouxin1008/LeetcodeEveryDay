import java.util.Collections;
import java.util.Deque;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
class No103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp = new ArrayList<>();
        TreeNode lastOfCurLevel = root;
        TreeNode lastOfNextLevel = root;
        boolean reverse = false;
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
                if(reverse){
                    Collections.reverse(temp);
                }
                res.add(temp);
                temp = new ArrayList<>();
                reverse = !reverse;
            }
        }
        return res;
    }
}

