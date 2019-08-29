#
# @lc app=leetcode id=486 lang=python3
#
# [486] Predict the Winner
#
class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [[ 0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in [ _ for _ in range(n) if _ + i < n]:
                a, b = j, j+i
                if i == 0: dp[a][b] = nums[a]
                else: dp[a][b] = max(nums[a] - dp[a+1][b], nums[b] - dp[a][b-1])
        return dp[0][n-1] >= 0

