import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class No128LongestConsecutiveSequence {
    class Range{
        int from;
        int to;
        public Range(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer,Range> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums) {
            if(set.contains(num)) continue;
            Integer from = null;
            if(map.containsKey(num-1)){
                Range r = map.remove(num-1);
                map.put(r.from, new Range(r.from, num));
                map.put(num, new Range(r.from, num));
                from = r.from;
                res = Math.max(res, num - from + 1);
            }
            if(map.containsKey(num+1)){
                Range r = map.remove(num+1);
                int to = r.to;
                if(from!=null){
                    map.remove(num);
                }else{
                    from = num;
                }
                map.put(from, new Range(from, to));
                map.put(to, new Range(from, to));
                res = Math.max(res, to - from + 1);
            }
            if(!map.containsKey(num)){
                map.put(num, new Range(num,num));
                res = Math.max(res, 1);
            }
            set.add(num);
        }
        return res;
    }
}

