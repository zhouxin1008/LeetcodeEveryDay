/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */
class No153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left]<nums[right]) {
                break;
            }
            int mid = (left + right) / 2;
            if(nums[mid]>=nums[left]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}

