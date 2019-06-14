import java.util.ArrayList;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
class No57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if(len == 0) return new int[][]{newInterval};
        List<int[]> res = new ArrayList<>();
        boolean merged = false;
        Integer left = null;
        Integer right = null;
        if(newInterval[0] <= intervals[0][0]) {
            left = newInterval[0];
            right = newInterval[1];
            merged = true;
        }
        for(int i=0; i<len; i++) {
            int[] temp = intervals[i];
            if(merged) {
                if(temp[0] > right){
                    res.add(new int[]{left, right});
                    left = temp[0];
                }
                right = Math.max(temp[1], right);
            } else {
                if(left == null) {
                    left = temp[0];
                    right = temp[1];
                } else {
                    if(temp[0] > right){
                        res.add(new int[]{left, right});
                        left = temp[0];
                    }
                    right = Math.max(temp[1], right);;
                }
                if(i+1 < len && intervals[i+1][0] >= newInterval[0]) {
                    merged = true;
                    intervals[i][0] = newInterval[0];
                    intervals[i][1] = newInterval[1];
                    i--;
                }
            }
        }
        if(!merged) {
            if(newInterval[0] > right){
                res.add(new int[]{left, right});
                left = newInterval[0];
            }
            right = Math.max(newInterval[1], right);
        }
        res.add(new int[]{left, right});
        int[][] result = new int[res.size()][];
        int index = 0;
        for(int[] num : res) {
            result[index] = num;
            index++;
        }
        return result;
    }
}

