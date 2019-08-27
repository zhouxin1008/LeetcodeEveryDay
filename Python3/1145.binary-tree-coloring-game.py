#
# @lc app=leetcode id=1145 lang=python3
#
# [1145] Binary Tree Coloring Game
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def btreeGameWinningMove(self, root: TreeNode, n: int, x: int) -> bool:
        left,right = 0, 0
        def count(root, x): 
            nonlocal left,right
            if not root: return 0
            left_count, right_count = count(root.left, x), count(root.right, x)
            if root.val == x:
                left, right = left_count, right_count
            return 1 + left_count + right_count
        count(root, x)
        return left > n//2 or right > n//2 or (n-left-right-1) > n//2

