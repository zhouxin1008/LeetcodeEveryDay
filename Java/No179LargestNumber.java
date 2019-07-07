import java.util.Arrays;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class No179LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0 ;i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (String x, String y) -> compare(x,y));
        if(Integer.parseInt(strs[0])==0) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }

    private int compare(String x, String y) {
        return -(x+y).compareTo(y+x);
    }
}

