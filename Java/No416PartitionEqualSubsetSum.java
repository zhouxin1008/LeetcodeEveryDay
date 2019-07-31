/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */
class No416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len==0) return true;
        int target = 0;
        for(int num : nums){
            target += num;
        }
        if(target%2!=0) return false;
        target = target/2;
        boolean[][] dp = new boolean[target+1][len];
        dp[0][0] = true;
        for(int i=1; i<=target; i++){
            boolean flag = false;
            for(int j=0; j<len; j++){
                if(flag) dp[i][j] = true;
                else {
                    if(i - nums[j] >= 0){
                        dp[i][j] = j==0 ? nums[j]==i : dp[i-nums[j]][j-1];
                        if(dp[i][j]){
                            flag = true;
                        }
                    }
                }
            }
        }
        return dp[target][len-1];
    }
}

