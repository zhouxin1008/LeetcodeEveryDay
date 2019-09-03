#
# @lc app=leetcode id=1129 lang=python3
#
# [1129] Shortest Path with Alternating Colors
#
class Solution:
    def shortestAlternatingPaths(self, n: int, red_edges: List[List[int]], blue_edges: List[List[int]]) -> List[int]:
        r_edges = [[] for i in range(n)]
        b_edges = [[] for i in range(n)]
        ans = [-1 for i in range(n)]
        for list in red_edges:
            r_edges[list[0]].append(list[1])
        for list in blue_edges:
            b_edges[list[0]].append(list[1])
        step, red, blue = 0, 0, 1
        q = [(0,red),(0,blue)]
        red_seen, blue_seen = set(), set()
        while(len(q) > 0):
            for i in range(len(q)):
                node = q.pop(0)
                if(ans[node[0]] == -1): ans[node[0]] = step
                if(node[1] == red and node[0] not in red_seen):
                    red_seen.add(node[0])
                    q.extend([(x, blue) for x in b_edges[node[0]]])
                if(node[1] == blue and node[0] not in blue_seen):
                    blue_seen.add(node[0])
                    q.extend([(x, red) for x in r_edges[node[0]]])
            step += 1
        return ans



