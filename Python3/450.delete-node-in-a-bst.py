#
# @lc app=leetcode id=450 lang=python3
#
# [450] Delete Node in a BST
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root: return root
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
            return root
        if root.val < key:
            root.right = self.deleteNode(root.right, key)
            return root
        
        if not root.left: return root.right
        if not root.right: return root.left
        parent, cur = root, root.right
        while cur and cur.left:
            parent = cur
            cur = cur.left
        if cur is not root.right:
            parent.left = cur.right
            cur.right = root.right
        cur.left = root.left
        return cur


