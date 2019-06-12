import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */
class No45JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int res = 0;
        int lastMax = 0;
        int curMax = 0;
        for(int i=0; i<nums.length; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (i == lastMax) {
                res++;
                lastMax = curMax;
                if( curMax >= nums.length-1 ) break;
            }
        }
        return res;
    }
}

