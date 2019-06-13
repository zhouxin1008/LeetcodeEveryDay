/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */
class No58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        char[] str = s.trim().toCharArray();
        for(char c : str) {
            if(c == ' ') res = 0;
            else res++;
        }
        return res;
    }
}

