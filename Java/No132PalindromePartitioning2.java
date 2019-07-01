import java.util.List;

/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */
class No132PalindromePartitioning2 {
    public int minCut(String s) {
        if(s==null || s.isEmpty()) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];
        char[] str = s.toCharArray();
        for(int i=0; i<len; i++){
            cut[i] = i;
            for(int j=0; j<=i; j++){
                if(str[i]==str[j] && (j+1>i-1 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    cut[i] = j==0 ? 0 : Math.min(cut[i], cut[j-1]+1);
                }
            }
        }
        return cut[len-1];
    }
}

