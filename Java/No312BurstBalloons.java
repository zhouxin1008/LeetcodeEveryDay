/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */
class No312BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] b = new int[nums.length+2];
        int len = b.length;
        for(int i=0; i<len; i++) {
            if(i==0 || i==len-1) b[i] = 1;
            else b[i] = nums[i-1];
        }
        int[][] dp = new int[len][len];
        for(int k=2; k<len; k++) {
            for(int left=0; left+k<len; left++) {
                int right = left + k;
                for(int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][i] + b[left]*b[i]*b[right] + dp[i][right]);
                }
            }
        }
        return dp[0][len-1];
    }
}

