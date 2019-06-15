/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */
class No66PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 0) return new int[]{1};
        int mark = 1;
        for(int i=len-1; i>=0; i--) {
            int temp = digits[i] + mark;
            mark = temp / 10;
            digits[i] = temp % 10;
        }
        if(mark == 0) return digits;
        else {
            int[] res = new int[len+1];
            res[0] = mark;        
            for(int i=0; i<len; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
    }
}

