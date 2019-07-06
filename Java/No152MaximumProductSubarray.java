/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class No152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int left = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) continue;
            if(i > left){
                max = Math.max(max, maxProduct(nums, left, i));
            }
            left = i+1;
        }
        if(left < nums.length) {
            max = Math.max(max, maxProduct(nums, left, nums.length));
        }
        return max;
    }

    private int maxProduct(int[] nums, int left, int right) {
        int max = 0;
        int cur = 1;
        for(int i=left; i<right; i++) {
            cur *= nums[i];
            max = Math.max(max, cur);
        }
        cur = 1;
        for(int i=right-1; i>=left; i--) {
            cur *= nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}

