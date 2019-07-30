import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */
class No368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len==0) return res;
        Arrays.sort(nums);
        int[] dp = new int[len];
        int[] back = new int[len];
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<len; i++){
            dp[i] = 1;
            back[i] = i;
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                    if(dp[i]  == dp[j]+1){
                        back[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        while(maxIndex != back[maxIndex]){
            res.addFirst(nums[maxIndex]);
            maxIndex = back[maxIndex];
        }
        res.addFirst(nums[maxIndex]);
        return res;
    }
}

