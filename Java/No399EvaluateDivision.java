import java.util.Map;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */
class Solution {
    class Pair {
        String p;
        double time;
        public Pair(String s, double d) {
            p = s;
            time = d;
        }
    }
    Map<String,String> parents = new HashMap<>();
    Map<String,Double> times = new HashMap<>();
    private Pair find(String s) {
        double time = 1.0;
        while(!s.equals(parents.get(s))) {
            time = time * times.get(s);
            s = parents.get(s);
        }
        return new Pair(s, time);
    }
    private void union(String s1, String s2, double time) {
        if(!parents.containsKey(s1)) {
            parents.put(s1, s1);
            times.put(s1, 1.0);
        }
        if(!parents.containsKey(s2)) {
            parents.put(s2, s2);
            times.put(s2, 1.0);
        }
        if(parents.get(s1).equals(s1)) {
            parents.put(s1, s2);
            times.put(s1, time);
        }else{
            union(parents.get(s1), s2, time/times.get(s1));
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<values.length; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            union(s1, s2, values[i]);
        }
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if(!parents.containsKey(s1) || !parents.containsKey(s2)){
                res[i] = -1;
                continue;
            }
            Pair p1 = find(s1);
            Pair p2 = find(s2);
            if(!p1.p.equals(p2.p)) {
                res[i] = -1;
            } else {
                res[i] = p1.time / p2.time;
            }
        }
        return res;
    }
}

