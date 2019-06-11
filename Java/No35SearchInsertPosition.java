/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */
class No35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return 0;
        if(target <= nums[0]) return 0;
        for(int i=1; i<len; i++) {
            if(nums[i-1] < target && nums[i] >= target)
            return i;
        }
        return len;
    }
}

