/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */
class No97InterleavingString {
    public boolean isInterleave(String S1, String S2, String S3) {
        if(S1.length()+S2.length()!=S3.length()) return false;
        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();
        char[] s3 = S3.toCharArray();
        boolean[][] dp = new boolean[s1.length+1][s2.length+1];
        dp[0][0] = true;
        for(int i=1; i<=s1.length; i++) {
            dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1];
        }
        for(int i=1; i<=s2.length; i++) {
            dp[0][i] = dp[0][i-1] && s2[i-1] == s3[i-1];
        }
        for(int i=1; i<=s1.length; i++) {
            for(int j=1; j<=s2.length; j++) {
                if(s1[i-1] == s3[i+j-1]) {
                    dp[i][j] |= dp[i-1][j];
                } 
                if(s2[j-1] == s3[i+j-1]) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}

