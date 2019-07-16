/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
class No322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount<0) return -1;
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    int temp = dp[i-coins[j]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i-coins[j]] + 1;
                    dp[i] = Math.min(temp, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

