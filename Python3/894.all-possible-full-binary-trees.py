#
# @lc app=leetcode id=894 lang=python3
#
# [894] All Possible Full Binary Trees
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.map = [[] for i in range(21)]

    def allPossibleFBT(self, N: int) -> List[TreeNode]:
        if N % 2 == 0: return []
        if N == 1: return [TreeNode(0)]
        if len(self.map[N]) !=0: return self.map[N]
        for i in range(1, N, 2):
            for l,r in itertools.product(self.allPossibleFBT(i), self.allPossibleFBT(N-i-1)):
                node = TreeNode(0)
                node.left = l
                node.right = r
                self.map[N].append(node)
        return self.map[N]


