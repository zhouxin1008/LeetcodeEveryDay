/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */
class No81SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int left = 0;
        int right = nums.length-1;
        return search(nums, target, left, right);
    }
    private boolean search(int[] nums, int target, int left, int right) {
        if(nums[left] == target || nums[right] == target) return true;
        if(right - left <= 1) return false;
        int mid = (left+right) / 2;
        if (nums[mid] > nums[left]) {// left part ascending
            if (target > nums[left] && target < nums[mid]) return search(nums, target, left, mid);
            else return search(nums, target, mid, right);
        } else if(nums[mid] < nums[left]) {// right part ascending
            if (target > nums[mid] && target < nums[right]) return search(nums, target, mid, right);
            else return search(nums, target, left, mid);
        } else {
            return search(nums, target, mid, right) || search(nums, target, left, mid);
        }
    }
}

