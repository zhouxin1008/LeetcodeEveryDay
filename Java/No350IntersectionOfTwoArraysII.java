import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */
class No350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums1) {
            int temp = count.getOrDefault(num, 0);
            temp++;
            count.put(num, temp);
        }
        for(int num : nums2) {
            int temp = count.getOrDefault(num, 0);
            if(temp > 0){
                temp--;
                count.put(num, temp);
                res.add(num);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}

