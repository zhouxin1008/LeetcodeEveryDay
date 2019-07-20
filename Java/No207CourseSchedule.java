import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class No207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] record : prerequisites){
            List<Integer> list = map.getOrDefault(record[0], new ArrayList<>());
            list.add(record[1]);
            map.put(record[0], list);
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> togo = new ArrayList<>();
        while(!map.isEmpty()){
            if(togo.isEmpty()) {
                togo.add(map.keySet().iterator().next());
                set.clear();
            }
            List<Integer> temp = new ArrayList<>();
            for(int i : togo) {
                List<Integer> v = map.remove(i);
                if(v!=null){
                    for(int j : v) {
                        if(set.contains(j)) return false;
                    }
                    temp.addAll(v);
                    set.add(i);
                }
            }
            togo = temp;
        }
        return true;
    }
}

