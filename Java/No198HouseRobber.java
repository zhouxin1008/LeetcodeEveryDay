/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */
class No198HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        for(int i=1; i<len ;i++){
            nums[i] = Math.max(nums[i-1], nums[i] + (i==1 ? 0 : nums[i-2]));
        }
        return Math.max(nums[len-1],nums[len-2]);
    }
}

