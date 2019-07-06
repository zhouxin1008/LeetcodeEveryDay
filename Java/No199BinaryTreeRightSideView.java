import java.util.Queue;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
class No199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode preLast = root;
        TreeNode curLast = root;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
                curLast = node.left;
            }
            if(node.right != null) {
                q.offer(node.right);
                curLast = node.right;
            }
            if(node == preLast) {
                res.add(node.val);
                preLast = curLast;
            }
        }
        return res;
    }
}

