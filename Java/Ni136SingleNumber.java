/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */
class Ni136SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}

