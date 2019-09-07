#
# @lc app=leetcode id=964 lang=python3
#
# [964] Least Operators to Express Number
#
import math
class Solution:
    def leastOpsExpressTarget(self, x: int, target: int) -> int:
        def dfs(num):
            if num == 0: return 0
            if num < x: return min(2*num, 2*(x-num)+1)
            if num in memo: return memo[num]
            n = math.floor(math.log(num, x))
            p = math.pow(x,n)
            if num == p:
                memo[num] = n
                return n
            left = num - p
            ans = dfs(left) + n
            if p*x - num < num:
                ans = min(ans, dfs(p*x - num)+n+1)
            memo[num] = ans
            return memo[num]
        memo = {}
        return int(dfs(target) - 1)
        
        

