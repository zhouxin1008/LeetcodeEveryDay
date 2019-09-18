#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(x, y): 
            if x<0 or x>=m or y<0 or y>=n: return
            if grid[x][y] != '1': return
            grid[x][y] = '0'
            for nx, ny in [(x+1,y), (x-1,y), (x, y-1), (x, y+1)]:
                dfs(nx, ny)
        
        m = len(grid)
        if m == 0: return 0
        n = len(grid[0])
        if n == 0: return 0
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    dfs(i, j)
        return count
