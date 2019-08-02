/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 */
class No292NimGame {
    // public boolean canWinNim(int n) {
    //     if(n<=3) return true;
    //     boolean[] dp = new boolean[3];
    //     dp[0] = dp[1] = dp[2] = true;
    //     for(int i=3; i<n; i++){
    //         boolean res = !(dp[0] && dp[1] && dp[2]);
    //         dp[0] = dp[1];
    //         dp[1] = dp[2];
    //         dp[2] = res;
    //     }
    //     return dp[2];
    // }

    public boolean canWinNim(int n){
        return n%4 != 0;
    }
}

