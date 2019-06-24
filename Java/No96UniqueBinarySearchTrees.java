/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */
class No96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        int[] mark = new int[n+1];
        mark[0] = mark[1] = 1;
        for(int i=2; i<=n; i++){
            int sum = 0;
            for(int p=0,q=i-1; p<=q; p++,q--){
                if(p!=q){
                    sum += mark[p]*mark[q]*2;
                }else{
                    sum += mark[p]*mark[q];
                }
            }
            mark[i] = sum;
        }
        return mark[n];
    }
}

