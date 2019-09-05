#
# @lc app=leetcode id=882 lang=python3
#
# [882] Reachable Nodes In Subdivided Graph
#
import heapq
class Solution:
    def reachableNodes(self, edges: List[List[int]], M: int, N: int) -> int:
        distance = [-1 for _ in range(N)]
        e = [[] for _ in range(N)]
        for i in edges:
            e[i[0]].append((i[2]+1,i[1]))
            e[i[1]].append((i[2]+1,i[0]))
        heap = [(0,0)] # (dis,index)
        while(len(heap) > 0):
            dis, node = heapq.heappop(heap)
            if distance[node] != -1: continue
            distance[node] = dis
            for neighber in e[node]:
                heapq.heappush(heap, (neighber[0]+dis, neighber[1]))
        ans = len([x for x in distance if x != -1 and x <= M])
        for edge in edges:
            a = 0 if distance[edge[0]] == -1 or distance[edge[0]] > M else M - distance[edge[0]]
            b = 0 if distance[edge[1]] == -1 or distance[edge[1]] > M else M - distance[edge[1]]
            ans += min(edge[2], a+b)
        return ans

