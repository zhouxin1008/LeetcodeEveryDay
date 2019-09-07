#
# @lc app=leetcode id=847 lang=python3
#
# [847] Shortest Path Visiting All Nodes
#
class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        n = len(graph)
        q = []
        target = (1 << n) - 1
        seen = set()
        for i in range(n):
            q.append((i, 1 << i))
            seen.add((i, 1 << i))
        step = 0
        while len(q) > 0:
            for i in range(len(q)):
                x, mask = q.pop(0)
                if mask == target: return step
                for n in graph[x]:
                    new_mask = mask | 1 << n
                    if (n,new_mask) in seen:
                        continue
                    seen.add((n, new_mask))
                    q.append((n, new_mask))
            step += 1
        return -1
