/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */
class No246UglyNumber2 {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int f2 = 0;
        int f3 = 0;
        int f5 = 0;
        for(int i=1; i<n; i++){
            int m2 = dp[f2] * 2;
            int m3 = dp[f3] * 3;
            int m5 = dp[f5] * 5;
            int min = Math.min(Math.min(m2, m3), m5);
            if(min == m2) f2++;
            if(min == m3) f3++;
            if(min == m5) f5++;
            dp[i] = min;
        }
        return dp[n-1];
    }
}

