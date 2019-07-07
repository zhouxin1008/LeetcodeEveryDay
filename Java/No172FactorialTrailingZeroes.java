/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */
class No172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int s = 0;
        while (n>4) s += (n/=5);
        return s;
    }
}

