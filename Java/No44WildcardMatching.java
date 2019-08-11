/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class No44WildcardMatching {
    public boolean isMatch(String S, String P) {
        char[] s = S.toCharArray();
        char[] p = P.toCharArray();
        int lenS = s.length;
        int lenP = p.length;
        boolean[][] dp = new boolean[lenP+1][lenS+1];
        for(int i=0; i<=lenP; i++){
            for(int j=0; j<=lenS; j++){
                if(i==0){
                    dp[i][j] = j==0;
                    continue;
                }
                if(j==0){
                    if(p[i-1] == '*') dp[i][j] = dp[i-1][j];
                    else dp[i][j] = false;
                    continue;
                }
                if(p[i-1] == '?' || p[i-1] == s[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                if(p[i-1] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                }
            }
        }
        return dp[lenP][lenS];
    }
}

