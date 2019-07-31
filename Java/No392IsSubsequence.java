/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */
class No392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen==0) return true;
        if(sLen>tLen) return false;
        boolean[][] dp = new boolean[sLen][tLen];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for(int i=0; i<sLen; i++){
            boolean match = false;
            char c = sArray[i];
            for(int j=i; j<tLen; j++){
                if(match){
                    dp[i][j] = true;
                }else if(tArray[j] == c){
                    dp[i][j] = i==0 || j==0 ? true : dp[i-1][j-1];
                    if(dp[i][j]){
                        match = true;
                    }
                }
            }
        }
        return dp[sLen-1][tLen-1];
    }
}

