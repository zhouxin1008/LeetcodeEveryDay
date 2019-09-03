#
# @lc app=leetcode id=417 lang=python3
#
# [417] Pacific Atlantic Water Flow
#
class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        def dfs(i, j, mark):
            if marks[i][j] == mark or marks[i][j] & mark != 0: return
            marks[i][j] |= mark
            if i>0 and matrix[i-1][j] >= matrix[i][j]:
                dfs(i-1, j, mark)
            if i<m-1 and matrix[i+1][j] >= matrix[i][j]:
                dfs(i+1, j, mark)
            if j>0 and matrix[i][j-1] >= matrix[i][j]:
                dfs(i, j-1, mark)
            if j<n-1 and matrix[i][j+1] >= matrix[i][j]:
                dfs(i, j+1, mark)
        m = len(matrix)
        if m == 0: return []
        n = len(matrix[0])
        if n == 0: return []
        marks = [[0 for i in range(n)] for j in range(m)]
        for i in range(m):
            dfs(i, 0, 1)
            dfs(i, n-1, 2)
        for i in range(n):
            dfs(0, i, 1)
            dfs(m-1, i, 2)
        ans = []
        for i in range(m):
            for j in range(n):
                if marks[i][j] == 3:
                    ans.append([i,j])
        return ans


        

