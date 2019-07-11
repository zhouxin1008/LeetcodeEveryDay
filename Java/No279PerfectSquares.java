/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
class No279PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int temp = (int)Math.sqrt(i);
            if(temp*temp == i){
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for(int j=i-1; j>=i-j; j--){
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }
}

