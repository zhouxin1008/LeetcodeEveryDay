/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */
class No684RedundantConnection {
    int[] p;
    private int find(int a) {
        while(p[a] != a){
            p[a] = p[p[a]];
            a = p[a];
        }
        return a;
    }
    private void union(int a, int b) {
        if(p[a] == a){
            p[a] = b;
        }else{
            union(p[a], b);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        p = new int[edges.length+1];
        for(int i=1; i<=edges.length; i++){
            p[i] = i;
        }
        for(int[] e : edges) {
            if(find(e[0]) == find(e[1])){
                return e;
            }
            union(e[0], e[1]);
        }
        return new int[0];
    }
}

