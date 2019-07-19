/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class No209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int i=0, j=0;
        while(i<nums.length && j<nums.length){
            sum+=nums[i];
            while(sum >= s) {
                res = Math.min(res, i-j+1);
                sum-=nums[j++];
            }
            i++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

