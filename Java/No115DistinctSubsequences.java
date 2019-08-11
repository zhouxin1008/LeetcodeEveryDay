/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */
class No115DistinctSubsequences {
    public int numDistinct(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int lenS = s.length;
        int lenT = t.length;
        int[][] dp = new int[lenT+1][lenS+1];
        for(int i=0; i<=lenT; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=lenS; i++) {
            dp[0][i] = 1;
        }
        for(int i=1; i<=lenT; i++) {
            for(int j=1; j<=lenS; j++){
                dp[i][j] += dp[i][j-1];
                if(t[i-1] == s[j-1]) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[lenT][lenS];
    }
}

