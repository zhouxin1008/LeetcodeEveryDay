import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class No300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(res == 0) {
                res = 1;
                map.put(res, num);
            } else {
                int temp = res;
                while(temp > 0){
                    int min = map.get(temp);
                    if(min < num){
                        res = Math.max(res, temp+1);
                        map.put(temp+1, Math.min(num, map.getOrDefault(temp+1, Integer.MAX_VALUE)));
                        temp=0;
                    }
                    if(num < min && temp==1){
                        map.put(1, num);
                    }
                    temp--;
                }
            }
        }
        return res;
    }
}

