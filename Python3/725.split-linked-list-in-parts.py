#
# @lc app=leetcode id=725 lang=python3
#
# [725] Split Linked List in Parts
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        def getLen(root):
            ans = 0
            while root:
                root = root.next
                ans += 1
            return ans
        length = getLen(root)
        sub = length // k
        count = length % k
        ans = [None for _ in range(k)]
        for i in range(k):
            tar = sub + 1 if count > 0 else sub
            if tar == 0: continue
            ans[i] = root
            while tar > 1:
                tar -= 1
                root = root.next
            pre, root = root, root.next
            pre.next = None
            count -= 1
        return ans


