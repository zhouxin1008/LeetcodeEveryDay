#
# @lc app=leetcode id=943 lang=python3
#
# [943] Find the Shortest Superstring
#
class Solution:
    def shortestSuperstring(self, A: List[str]) -> str:
        def getDistance(s1, s2):
            for i in range(0, len(s1)):
                if s2.startswith(s1[i:]):
                    return len(s1) - i
            return 0

        n = len(A)
        dis = [[0]*n for _ in range(n)]
        max_len = 0
        for i in range(n):
            max_len += len(A[i])
            for j in range(i+1, n):
                dis[i][j] = getDistance(A[i], A[j])
                dis[j][i] = getDistance(A[j], A[i])
        dp = [[max_len+1 for _ in range(n)] for _ in range(1<<n)]
        parent = [[None for _ in range(n)] for _ in range(1<<n)]

        for i in range(n): 
            dp[1<<i][i] = len(A[i])
        for i in range(1<<n):
            for j in range(n):
                if i & 1<<j == 0: continue
                prev = i - (1<<j)
                for k in range(n):
                    if j != k and dp[prev][k] + len(A[j]) - dis[k][j] < dp[i][j]:
                        dp[i][j] = dp[prev][k] + len(A[j]) - dis[k][j]
                        parent[i][j] = k
        target = (1<<n) - 1
        index = dp[target].index(min(dp[target]))
        res = A[index]
        while index != None:
            next_index = parent[target][index]
            next_target = target - (1<<index)
            if next_index is None: break
            if next_index is None or dis[next_index][index] == 0:
                res = A[next_index] + res
            else:
                res = A[next_index] + res[dis[next_index][index]:]
            target = next_target
            index = next_index
        return res


