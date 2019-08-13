/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class No387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] mark = new int[26];
        for(int i=0; i<26; i++) {
            mark[i] = -1;
        }
        char[] ss = s.toCharArray();
        for(int i=0; i<ss.length; i++) {
            int index = ss[i] - 'a';
            if (mark[index] == -1) {
                mark[index] = i;
            } else if(mark[index] >=0) {
                mark[index] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(mark[i] >=0 ){
                res = Math.min(mark[i], res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

