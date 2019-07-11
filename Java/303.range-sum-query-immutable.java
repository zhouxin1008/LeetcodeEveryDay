/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */
class No303RangeSumQueryImmutable {

    private int[] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len];
        for(int i=0; i<len; i++){
            if(i==0) sum[i] = nums[i];
            else sum[i] = nums[i] + sum[i-1];
        }
    }
    
    public int sumRange(int i, int j) { 
        if(i==0) return sum[j];
        return sum[j] - sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

