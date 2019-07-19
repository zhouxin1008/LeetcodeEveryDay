import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */
class No219ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0, j=0; j<nums.length; j++){
            if(j-i > k){
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j])){
                return true;
            }
            set.add(nums[j]);
        }
        return false;
    }
}

