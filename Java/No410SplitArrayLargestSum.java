/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */
class No410SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        if(m >= len){
            int res = Integer.MIN_VALUE;
            for(int num : nums){
                res = Math.max(num, res);
            }
            return res;
        }
        int[][] dp = new int[m][len];
        for(int i=0; i<m; i++){
            for(int j=0; j<len; j++){
                if(i==0) {
                    if(j==0) dp[i][j] = nums[j];
                    else dp[i][j] = nums[j] + dp[i][j-1];
                }else{
                    if(j==0) dp[i][j] = nums[j];
                    int sum = nums[j];
                    dp[i][j] = Integer.MAX_VALUE;
                    inner_loop:
                    for(int k=j-1; k>=i-1; k--){
                        if(sum > dp[i][j]) break inner_loop;
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k],sum));
                        sum += nums[k];
                    }
                }
            }
        }
        return dp[m-1][len-1];
    }
}

