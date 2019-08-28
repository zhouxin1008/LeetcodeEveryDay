#
# @lc app=leetcode id=865 lang=python3
#
# [865] Smallest Subtree with all the Deepest Nodes
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        def depth(root):
            if not root: return (0, root)
            left, right = depth(root.left), depth(root.right)
            d = max(left[0], right[0]) + 1
            node = root if left[0] == right[0] else (left[1] if left[0] > right[0] else right[1])
            return (d, node)
        return depth(root)[1]

