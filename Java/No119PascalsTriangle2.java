import java.util.Arrays;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */
class No119PascalsTriangle2 {
    private int[] res;
    public List<Integer> getRow(int rowIndex) {
        res = new int[rowIndex+1];
        for(int i=1; i<=rowIndex+1; i++){
            doGetRow(i);
        }
        
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
    private void doGetRow(int n) {
        if(n==1){
            res[0] = 1;
            return;
        }
        if(n>2){
            for(int i=0; i<n-1; i++){
                res[i] = res[i] + res[i+1];
            }
        }
        for(int i=n-1; i>0; i--){
            res[i] = res[i-1];
        }
        res[0] = 1;
    }
}

