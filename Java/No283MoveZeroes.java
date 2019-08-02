/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */
class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i=0, j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                swap(nums,i++, j);
            } 
            j++;
            
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

