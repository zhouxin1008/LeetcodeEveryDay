#
# @lc app=leetcode id=889 lang=python3
#
# [889] Construct Binary Tree from Preorder and Postorder Traversal
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        def build(i, j, n):
            if n <= 0: return None
            root = TreeNode(pre[i])
            if n == 1: return root
            k = index[pre[i+1]]
            l = k-j+1
            root.left = build(i+1, j, l)
            root.right = build(i+1+l, k+1, n-l-1)
            return root
        index = {}
        for i, v in enumerate(post):
            index[v] = i
        return build(0, 0, len(pre))

