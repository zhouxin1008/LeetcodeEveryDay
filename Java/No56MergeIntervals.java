import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class No56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, (o1,o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            int[] value = intervals[i];
            if(value[0] <= temp[1]) {
                temp[1] = Math.max(value[1], temp[1]);
            } else {
                res.add(temp);
                temp = value;
            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
}

