/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class No33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        return search(nums, target, left, right);
    }
    private  int search(int[] nums, int target, int left, int right) {
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        if(right - left <= 1) return -1;
        int mid = (left+right) / 2;
        if (nums[mid] >= nums[left]) {
            if (target > nums[left] && target < nums[mid]) return search(nums, target, left, mid);
            else return search(nums, target, mid, right);
        } else {
            if (target > nums[mid] && target < nums[right]) return search(nums, target, mid, right);
            else return search(nums, target, left, mid);
        }
    }
}

