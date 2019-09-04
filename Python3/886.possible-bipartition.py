#
# @lc app=leetcode id=886 lang=python3
#
# [886] Possible Bipartition
#
class Solution:
    def possibleBipartition(self, N: int, dislikes: List[List[int]]) -> bool:
        neighbor_list = [[] for _ in range(N)]
        for dislike in dislikes:
            neighbor_list[dislike[0] - 1].append(dislike[1] - 1)
            neighbor_list[dislike[1] - 1].append(dislike[0] - 1)
        mark = [0 for _ in range(N)]
        def dfs(index, color, first):
            if first and mark[index] != 0: return True
            if mark[index] == color: return True
            if mark[index] == -color: return False
            mark[index] = color
            for i in neighbor_list[index]:
                if not dfs(i, -color, False): return False
            return True
        for i in range(N):
            if mark[i] == 0 and len(neighbor_list[i]) > 0:
                if not dfs(i, 1, True): return False
        return True
