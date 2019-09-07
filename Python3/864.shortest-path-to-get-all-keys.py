#
# @lc app=leetcode id=864 lang=python3
#
# [864] Shortest Path to Get All Keys
#
class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        n, m = len(grid), len(grid[0])
        q = []
        seen = set()
        keys = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '@':
                    q.append((i,j,0))
                if grid[i][j] in "abcdef":
                    keys |= 1 << (ord(grid[i][j]) - ord('a'))
        step = 0
        while len(q)>0:
            for i in range(len(q)):
                x,y,key = q.pop(0)
                if key == keys: return step
                if (x,y,key) in seen: continue
                seen.add((x,y,key))
                for nx,ny in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
                    if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
                    char = grid[nx][ny]
                    if char == '.' or char == '@': 
                        q.append((nx,ny,key))
                    elif char in "abcdef":
                        new_key = key | 1 << (ord(char) - ord('a'))
                        q.append((nx,ny,new_key))
                    elif char in "ABCDEF":
                        mask = 1 << (ord(char) - ord('A'))
                        if key & mask != 0:
                            q.append((nx,ny,key))
            step += 1
        return -1
                
