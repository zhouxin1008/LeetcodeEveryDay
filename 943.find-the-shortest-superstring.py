#
# @lc app=leetcode id=943 lang=python3
#
# [943] Find the Shortest Superstring
#
class Solution:
    def shortestSuperstring(self, A: List[str]) -> str:
        def getDistance(s1, s2):
            for i in range(1, len(s1)):
                if s2.startswith(s1[i:]):
                    return len(s1) - i
            return 0

        def dfs(index, path, cur_len):
            nonlocal min_len,ans
            if cur_len >= min_len: return
            if len(A) == len(path):
                ans = path[:]
                min_len = cur_len
                return
            _list1 = [i for i in range(n) if mark[i] == 0 and dis[index][i]>0]
            for i in _list1:
                mark[i] = 1
                path.append(i)
                dfs(i, path, cur_len + len(A[i]) - dis[index][i])
                path.pop()
                mark[i] = 0
            _list2 = [i for i in range(n) if mark[i] == 0 and dis[index][i]==0]
            for i in _list2:
                mark[i] = 1
                path.append(i)
                dfs(i, path, cur_len + len(A[i]))
                path.pop()
                mark[i] = 0
            

        n = len(A)
        dis = [[0]*n for _ in range(n)]
        for i in range(n):
            for j in range(i+1, n):
                dis[i][j] = getDistance(A[i], A[j])
                dis[j][i] = getDistance(A[j], A[i])

        ans = []
        min_len = sys.maxsize
        mark = [0 for _ in range(n)]
        for i in range(n):
            mark[i] = 1
            dfs(i, [i], len(A[i]))
            mark[i] = 0
        res = A[ans[0]]
        for i in range(1,n):
            res += A[ans[i]][dis[ans[i-1]][ans[i]]:]
        return res


