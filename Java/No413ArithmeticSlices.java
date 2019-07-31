/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */
class No413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int count = 0;
        for(int i=2; i<A.length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                count++;
                res+=count;
            }else{
                count = 0;
            }
        }
        return res;
    }
}

