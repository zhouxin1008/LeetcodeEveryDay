import java.util.Set;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class No41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)) return i;
        }
        return nums.length+1;
    }
}

