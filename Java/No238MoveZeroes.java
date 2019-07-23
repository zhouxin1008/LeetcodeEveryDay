/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */
class No238MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[right] != 0) {
                swap(nums, left++, right++);
            }else{
                right++;
            }
        }
    }
    private void swap(int[] nums, int i ,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

