import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */
class No310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(i);
        }
        if(set.size()<=2) return new ArrayList<>(set);
        int[] inDegree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
            Set<Integer> list = map.getOrDefault(edge[1], new HashSet<>());
            list.add(edge[0]);
            map.put(edge[1], list);
            list = map.getOrDefault(edge[0], new HashSet<>());
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        Set<Integer> reached = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(inDegree[i] == 1) {
                reached.add(i);
                set.remove(i);
            }
        }
        while(set.size()>2){
            Set<Integer> togo = new HashSet<>();
            for(int num : reached){
                Set<Integer> list = map.get(num);
                for(int index : list) {
                    inDegree[index]--;
                    if(inDegree[index]==1){
                        togo.add(index);
                        set.remove(index);
                    }
                }
            }
            reached = togo;
        }
        return new ArrayList<>(set);
    }
}

