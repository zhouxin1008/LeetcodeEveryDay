#
# @lc app=leetcode id=547 lang=python3
#
# [547] Friend Circles
#
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        def dfs(x, color):
            for i in range(len(M[x])):
                if (M[x][i] == 1):
                    M[x][i] = color
                    dfs(i, color)
        color = 1
        for i in range(len(M)):
            for j in range(len(M[i])):
                if M[i][j] == 1:
                    color += 1
                    dfs(i, color)
                    break
        return color - 1

