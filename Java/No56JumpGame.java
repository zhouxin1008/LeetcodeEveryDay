/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class No56JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if(i>max) break;
            max = Math.max(max, i+nums[i]);
        }
        if(max < nums.length-1) return false;
        return true;
    }
}

