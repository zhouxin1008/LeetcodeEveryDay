import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
class No76MinimumWindowSubstring {
    class Index {
        char key;
        int value;
        public Index(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public String minWindow(String s, String t) {
        if(s.equals("") || t.equals("")) return "";
        Deque<Index> q = new LinkedList<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for(char c : t.toCharArray()){
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> count = new HashMap<>();
        char[] str = s.toCharArray();
        String result = "";
        int resLen = Integer.MAX_VALUE;
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            if(!tCount.containsKey(c)) {
                continue;
            }
            q.offerLast(new Index(c, i));
            count.put(c, count.getOrDefault(c,0)+1);
            
            while(!q.isEmpty() && count.get(q.peekFirst().key) > tCount.get(q.peekFirst().key)) {
                char key = q.pollFirst().key;
                count.put(key,count.get(key)-1);
            }

            if(containsAnswer(tCount, count)){
                int left = q.peekFirst().value;
                int right = q.peekLast().value;
                if(right-left+1 < resLen) {
                    resLen = right-left+1;
                    result = s.substring(left,right+1);
                }
            }
            
        }
        return result;
    }

    private boolean containsAnswer(Map<Character, Integer> a, Map<Character, Integer> b) {
        for(Map.Entry<Character, Integer> e : a.entrySet()){
            if(b.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }
}

