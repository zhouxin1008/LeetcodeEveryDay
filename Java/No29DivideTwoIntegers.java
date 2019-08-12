/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */
class No29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lans = ldivide(ldividend, ldivisor);
        if(lans > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign*(int)lans;
    }

    private long ldivide(long dividend, long divisor) {
        if(divisor > dividend) return 0;
        long sum = divisor;
        long ans = 1;
        while(sum <= dividend) {
            sum += sum;
            ans += ans;
        }
        return ans/2 + ldivide(dividend - sum/2, divisor);
    }
}

