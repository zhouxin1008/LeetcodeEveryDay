#
# @lc app=leetcode id=863 lang=python3
#
# [863] All Nodes Distance K in Binary Tree
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root, target, K):
        """
        :type root: TreeNode
        :type target: TreeNode
        :type K: int
        :rtype: List[int]
        """
        def find(node, k):
            if not node: return
            if k < 0: return 
            if k == 0: ans.append(node.val)
            find(node.left, k-1)
            find(node.right, k-1)
        def getDistance(node):
            if not node: return -1
            if node is target:
                find(node, K)
                return 0
            l, r = getDistance(node.left), getDistance(node.right)
            if l >= 0:
                if l == K-1: ans.append(node.val)
                find(node.right, K - 2 - l)
                return l+1
            if r >= 0:
                if r == K-1: ans.append(node.val)
                find(node.left, K - 2 - r)
                return r+1
            return -1
            
        ans = []
        getDistance(root)
        return ans

