import java.util.Arrays;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class No135Candy {
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                nums[i] = Math.max(nums[i], nums[i+1]+1);
            }
        }
        int res = 0;
        for(int num : nums){
            res += num;
        }
        return res;
    }
}

