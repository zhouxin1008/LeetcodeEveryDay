import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class No207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Set<Integer>> edges = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            edges.add(new HashSet<>());
        }
        for(int[] req : prerequisites) {
            int from = req[1];
            int to = req[0];
            inDegree[to]++;
            edges.get(from).add(to);
        }
        for(int i=0; i<numCourses; i++) {
            int course = 0;
            for(; course<numCourses; course++) {
                if(inDegree[course]==0) break;
            }
            if(course == numCourses) return false;
            inDegree[course] = -1;
            for(int c : edges.get(course)){
                inDegree[c] = inDegree[c]-1;
            }
        }
        return true;
    }
}

