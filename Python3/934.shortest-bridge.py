#
# @lc app=leetcode id=934 lang=python3
#
# [934] Shortest Bridge
#
class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        def dfs(i, j):
            if i<0 or i>=m or j<0 or j>=n: return
            if A[i][j] == 0 or A[i][j] == 2: return
            A[i][j] = 2
            q.append((i,j))
            for ni,nj in [(i+1,j),(i-1,j),(i,j+1),(i,j-1)]:
                dfs(ni,nj)
        m, n = len(A), len(A[0])
        q = []
        flag = True
        for i in range(m):
            for j in range(n):
                if A[i][j] == 1 and flag:
                    dfs(i,j)
                    flag = False
        ans = 0
        while len(q)>0:
            for i in range(len(q)):
                x,y = q.pop(0)
                for nx,ny in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
                    if nx<0 or nx>=m or ny<0 or ny>=n: continue
                    if A[nx][ny] == 1: return ans
                    if A[nx][ny] == 0:
                        A[nx][ny] = 2
                        q.append((nx,ny))
            ans += 1
        return -1

        

