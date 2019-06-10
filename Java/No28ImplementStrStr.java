/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */
class No28ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        for(int i=0; i+needle.length()<=haystack.length(); i++) {
            if(haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }
}

