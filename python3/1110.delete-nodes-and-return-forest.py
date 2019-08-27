#
# @lc app=leetcode id=1110 lang=python3
#
# [1110] Delete Nodes And Return Forest
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        res = []
        ds = set(to_delete)
        def process(node):
            if not node: return node
            node.left,node.right = process(node.left), process(node.right)
            if node.val not in ds: return node
            if node.left: res.append(node.left)
            if node.right: res.append(node.right)
            return None
        root = process(root)
        if root: res.append(root)
        return res
        

