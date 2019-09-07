#
# @lc app=leetcode id=817 lang=python3
#
# [817] Linked List Components
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def numComponents(self, head: ListNode, G: List[int]) -> int:
        memo, count, last_flag = set(G), 0, False
        while head:
            if head.val in memo and not last_flag:
                count += 1
                last_flag = True
            if head.val not in memo and last_flag:
                last_flag = False
            head = head.next
        return count


