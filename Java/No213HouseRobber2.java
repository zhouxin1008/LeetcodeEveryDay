/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */
class No213HouseRobber2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        return Math.max(doRob(nums, 0, len-2), doRob(nums, 1, len-1));
    }
    private int doRob(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        for(int i=start+1; i<=end; i++){
            if(i==start+1){
                dp[i] = Math.max(nums[i], dp[i-1]);
            }else{
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
        }
        return dp[end];
    }
}

