/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */
class No268MissingNumber {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        int expectSum = 0;
        for(int i=0; i<nums.length; i++){
            expectSum += i;
            actualSum += nums[i];
        }
        return expectSum + nums.length - actualSum;
    }
}

