import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
class No113PathSum2 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         res = new ArrayList<>();
         List<Integer> list = new ArrayList<>();
         helper(root, sum, list);
         return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        sum = sum - root.val;
        if(sum==0 && root.left==null && root.right==null){
            res.add(list);
            return;
        }
        helper(root.left, sum, new ArrayList<>(list));
        helper(root.right, sum, new ArrayList<>(list));
   }
}

