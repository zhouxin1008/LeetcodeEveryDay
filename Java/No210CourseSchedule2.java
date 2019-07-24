import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class No210CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
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
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0) {
                q.offer(i);
                inDegree[i] = -1;
            }
        }
        while(index < numCourses) {
            if(q.isEmpty()) return new int[0];
            int course = q.poll();
            res[index++] = course;
            for(int c : edges.get(course)){
                inDegree[c] = inDegree[c] - 1;
                if(inDegree[c] == 0) q.offer(c);
            }
        }
        return res;
    }
}

