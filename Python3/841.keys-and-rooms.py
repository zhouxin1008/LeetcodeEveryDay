#
# @lc app=leetcode id=841 lang=python3
#
# [841] Keys and Rooms
#
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        def dfs(room):
            if visited[room] == 1: return
            visited[room] = 1
            for key in rooms[room]:
                dfs(key)
        n = len(rooms)
        visited = [0 for _ in range(n)]
        dfs(0)
        return sum(visited) == n
