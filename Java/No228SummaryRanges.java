import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class No228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int left = nums[0];
        int right = nums[0];
        for(int i=1; i<=nums.length; i++){
            if(i!=nums.length && nums[i] == nums[i-1]+1){
                right = nums[i];
            }else{
                if(left==right){
                    res.add(left+"");
                }else{
                    res.add(left+"->"+right);
                }
                if(i!=nums.length){
                    left = right = nums[i];
                }
            }
        }
        return res;
    }
}

