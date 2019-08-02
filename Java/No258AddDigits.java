/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */
class No258AddDigits {
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num%9==0) return 9;
        return num%9;
    }
}

