/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */
class No376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int[] positive = new int[len];
        int[] negative = new int[len];
        int max = 0;
        for(int i=0; i<len; i++){
            positive[i] = 1;
            negative[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    positive[i] = Math.max(positive[i], negative[j]+1);
                }else if(nums[i] < nums[j]){
                    negative[i] = Math.max(negative[i], positive[j]+1);
                }
            }
            max = Math.max(max, Math.max(positive[i], negative[i]));
        }
        return max;
    }
}

