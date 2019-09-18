#
# @lc app=leetcode id=733 lang=python3
#
# [733] Flood Fill
#
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        def dfs(x, y, old, new):
            if x < 0 or x >= m or y < 0 or y >=n: return
            if image[x][y] != old: return
            image[x][y] = new
            dfs(x-1, y, old, new)
            dfs(x+1, y, old, new)
            dfs(x, y+1, old, new)
            dfs(x, y-1, old, new)
        if image[sr][sc] == newColor: return image
        m = len(image)
        if m == 0: return image
        n = len(image[0])
        if n == 0: return image
        dfs(sr, sc, image[sr][sc], newColor)
        return image

