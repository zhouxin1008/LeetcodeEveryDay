#
# @lc app=leetcode id=207 lang=python3
#
# [207] Course Schedule
#
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def dfs(x):
            if mark[x] == 1: return True
            if mark[x] == 2: return False
            mark[x] = 1
            res = False
            for y in edges[x]:
                res = res | dfs(y)
            mark[x] = 2
            return res

        edges = [[] for _ in range(numCourses)]
        for l in prerequisites:
            edges[l[0]].append(l[1])
        mark = [0 for _ in range(numCourses)]
        for i in range(numCourses):
            if mark[i] == 0:
                if(dfs(i)): return False
        return True
        

