/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */
class No685RedundantConnectionII {
    int[] parents;
    private boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;
        parents[pa] = pb;
        return true;
    }
    private int find(int a) {
        while(parents[a] != a){
            parents[a] = parents[parents[a]];
            a = parents[a];
        }
        return a;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        parents = new int[edges.length+1];
        int[] ans1 = null;
        int[] ans2 = null;
        for(int[] e : edges) {
            if(parents[e[1]] != 0) {
                ans1 = new int[2]; ans1[0] = parents[e[1]]; ans1[1] = e[1];
                ans2 = new int[2]; ans2[0] = e[0]; ans2[1] = e[1];
                e[0] = e[1] = -1;
                break;
            }
            parents[e[1]] = e[0];
        }
        for(int i=0; i<=edges.length; i++){
            parents[i] = i;
        }
        for(int[] e : edges) {
            if(e[0] < 0 || e[1] < 0) continue;
            if(!union(e[0], e[1])) {
                return ans1 != null ? ans1 : e;
            }
        }
        return ans2;
    }
}

