#
# @lc app=leetcode id=778 lang=python3
#
# [778] Swim in Rising Water
#
import heapq

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        ans = 0
        heap = [(grid[0][0], 0, 0)]
        visited = set()
        while(len(heap) > 0):
            h, i, j = heapq.heappop(heap)
            if (i,j) in visited: continue
            visited.add((i, j))
            ans = max(ans, h)
            if i==n-1 and j==n-1: return ans
            for ni, nj in [(i+1,j), (i-1,j), (i,j+1), (i,j-1)]:
                if 0<=ni<n and 0<=nj<n and (ni,nj) not in visited:
                    heapq.heappush(heap, (grid[ni][nj], ni, nj))
        return -1

