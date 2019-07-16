/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */
class No343IntegerBreak {
    public int integerBreak(int n) {
        if(n<=1) return 0;
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=1; j<=i-j; j++){
                dp[i] = Math.max(dp[i], Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
}

