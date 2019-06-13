/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums) {
            sum = sum + n;
            max = Math.max(sum, max);
            if(sum < 0) sum = 0;
        }
        return max;
    }
}

