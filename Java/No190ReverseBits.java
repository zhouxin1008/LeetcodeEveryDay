/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */
public class No190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        String reverse = new StringBuffer(s).reverse().toString();
        int diff = 32 - reverse.length();
        return Integer.parseUnsignedInt(reverse, 2) << diff;
    }
}

