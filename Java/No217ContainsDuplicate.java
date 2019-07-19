import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */
class No217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}

