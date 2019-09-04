#
# @lc app=leetcode id=785 lang=python3
#
# [785] Is Graph Bipartite?
#
class Solution:
    # BFS
    # def isBipartite(self, graph: List[List[int]]) -> bool:
    #     n = len(graph)
    #     mark = [0 for _ in range(n)]
    #     for i,v in enumerate(mark):
    #         if v != 0: continue
    #         q = [i]
    #         color = 1
    #         while len(q) > 0:
    #             for _ in range(len(q)):
    #                 node = q.pop(0)
    #                 if mark[node] == -color: return False
    #                 if mark[node] != 0: continue
    #                 mark[node] = color
    #                 for neighbor in graph[node]:
    #                     q.append(neighbor)
    #             color = -color
    #     return True

    # DFS
    def isBipartite(self, graph: List[List[int]]) -> bool:
        def dfs(index, color, first):
            print(index, mark[index])
            if first and mark[index] != 0: return True
            if mark[index] == color: return True
            if mark[index] == -color: return False
            mark[index] = color
            for i in graph[index]:
                if not dfs(i, -color, False): return False
            return True
        n = len(graph)
        mark = [0 for _ in range(n)]
        for i in range(n):
            if not dfs(i, 1, True): return False
        return True
        


