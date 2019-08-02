/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */
class No231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1))==0 && n>0);
    }
}

