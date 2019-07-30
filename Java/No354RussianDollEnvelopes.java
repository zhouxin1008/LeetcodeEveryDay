/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */
class No354RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if(len<2) return len;
        int res = 0;
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1]; // [2,7] should before [2,5]
            } else {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[len];
        for(int i=0; i<len; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

