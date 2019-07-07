/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */
class No189RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        while(k!=0){
            rotateOne(nums);
            k--;
        }
    }
    private void rotateOne(int[] nums){
        int last = nums[nums.length-1];
        for(int i=nums.length-1; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }
}

