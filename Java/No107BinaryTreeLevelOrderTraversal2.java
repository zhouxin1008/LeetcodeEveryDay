/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
class No107BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res);
        return res;
    }
}

