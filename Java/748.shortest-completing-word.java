/*
 * @lc app=leetcode id=748 lang=java
 *
 * [748] Shortest Completing Word
 */
class No748ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for(char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                count[c-'a']++;
            }
        }
        String ans = null;
        for(String word : words) {
            if(ans!=null && word.length() >= ans.length()) continue;
            int[] temp = new int[26];
            for(char c : word.toCharArray()) {
                temp[c-'a']++;
            }
            boolean cover = true;
            for(int i=0; i<26; i++) {
                if(temp[i] < count[i]) {
                    cover = false;
                }
            }
            if(cover) ans = word;
        }
        return ans;
    }
}

