/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
class No241ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.length()!=t.length()) return false;
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c-'a']++;
        }
        for(char c : t.toCharArray()){
            map[c-'a']--;
        }
        for(int c : map){
            if(c!=0) return false;
        }
        return true;
    }
}

