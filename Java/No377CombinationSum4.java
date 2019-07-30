/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */
class No377CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[target+1][len]; // sum is i && last num is nums[j]
        int[] max = new int[target+1];
        max[0] = 1;
        for(int i=1; i<=target; i++){
            for(int j=0; j<len; j++){
                if(i-nums[j] >= 0){
                    dp[i][j] += max[i-nums[j]];
                }
                max[i] += dp[i][j];
            }
        }
        return max[target];
    }
}

