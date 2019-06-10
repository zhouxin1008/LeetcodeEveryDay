import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class No30SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;
        Map<String, Integer> wordsMap = new HashMap<>();
        int numOfWords = words.length;
        int wordLen = words[0].length();
        int subStrLen = wordLen * numOfWords;
        for (String temp : words) {
            wordsMap.put(temp, wordsMap.getOrDefault(temp, 0) + 1);
        }
        for(int i=0; i+subStrLen<=s.length(); i++) {
            String temp = s.substring(i, i+subStrLen);
            Map<String, Integer> tempMap = generateMap(temp, wordLen);
            boolean flag = true;
            for(Map.Entry<String, Integer> entry : tempMap.entrySet()) {
                if(flag && wordsMap.getOrDefault(entry.getKey(), 0) != entry.getValue()) {
                    flag = false;
                }
            }
            if(flag) res.add(i);
        }
        return res;
    }

    private Map<String, Integer> generateMap(String s, int len) {
        Map<String, Integer> res = new HashMap<>();
        int left = 0;
        int right = len;
        while(right <= s.length()) {
            String temp = s.substring(left, right);
            res.put(temp, res.getOrDefault(temp, 0) + 1);
            left+=len;
            right+=len;
        }
        return res;
    }
}

