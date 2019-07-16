/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */
class No338CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1; i<=num; i++){
            int half = i/2;
            dp[i] = i%2==1 ? dp[half]+1 : dp[half];
        }
        return dp;
    }
}

