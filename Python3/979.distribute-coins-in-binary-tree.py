#
# @lc app=leetcode id=979 lang=python3
#
# [979] Distribute Coins in Binary Tree
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        ans = 0
        def move(root: TreeNode) -> int:
            nonlocal ans
            if not root: return 0
            left, right = move(root.left), move(root.right)
            ans = ans + abs(left) + abs(right)
            return root.val + left + right - 1
        move(root)
        return ans

        

