/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int len = nums.length;
        int i = len - 2;
        while(i >= 0 && nums[i+1] <= nums[i]) i--;
        if (i >= 0) {
            int j = len - 1;
            while(nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, len-1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
}

