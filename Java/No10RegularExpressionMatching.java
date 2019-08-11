/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class No10RegularExpressionMatching {
    public boolean isMatch(String S, String P) {
        char[] s = S.toCharArray();
        char[] p = P.toCharArray();
        int lenP = p.length;
        int lenS = s.length;
        boolean[][] dp = new boolean[lenP+1][lenS+1];

        for(int i=0; i<=lenP; i++){
            for(int j=0; j<=lenS; j++) {
                dp[i][j] = false;
                if(i==0) {
                    dp[i][j] = j==0;
                    continue;
                }
                if(j==0) {
                    if(p[i-1] == '*' && i>=2) dp[i][j] = dp[i-2][j];
                    else dp[i][j] = false;
                    continue;
                }
                if(p[i-1] == s[j-1] || p[i-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p[i-1] == '*' && i>=2) {
                    dp[i][j] |= dp[i-2][j];
                    if(p[i-2] == s[j-1] || p[i-2] == '.') dp[i][j] |= (dp[i-2][j-1] || dp[i][j-1]);
                }
            }
        }
        return dp[lenP][lenS];
    }
}

