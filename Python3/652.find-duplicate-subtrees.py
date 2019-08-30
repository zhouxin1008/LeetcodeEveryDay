#
# @lc app=leetcode id=652 lang=python3
#
# [652] Find Duplicate Subtrees
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        # def stringfy(node):
        #     if not node: return '#'
        #     res = f'{node.val},{stringfy(node.left)},{stringfy(node.right)}'
        #     if map.get(res,0) == 1: ans.append(node)
        #     map[res] = map.get(res,0) + 1
        #     return res
        # map = {}
        # ans = []
        # stringfy(root)
        # return ans
        def stringfy(node):
            if not node: return '#'
            res = f'{node.val},{stringfy(node.left)},{stringfy(node.right)}'
            map[res].append(node)
            return res
        map = collections.defaultdict(list)
        stringfy(root)
        return [map[key][0] for key in map if len(map[key]) > 1]
