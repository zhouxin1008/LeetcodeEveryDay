import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
class No126WordLadderII {
    List<List<String>> res;
    Map<String, List<String>> parents;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for(String w : wordList) {
            dict.add(w);
        }
        if(!dict.contains(endWord)) return res;
        dict.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        parents = new HashMap<>();
        boolean find = false;
        q.offer(beginWord);
        out: 
        while(!q.isEmpty()) {
            int len = q.size();
            Set<String> level = new HashSet<>();
            while(len > 0) {
                len--;
                String p = q.poll();
                if(p.equals(endWord)) {
                    find = true;
                    break out;
                }
                char[] s = p.toCharArray();
                for(int i=0; i<s.length; i++) {
                    for(char c='a'; c<='z'; c++){
                        if(c == s[i]) continue;
                        char old = s[i];
                        s[i] = c;
                        String str = new String(s);
                        if(dict.contains(str)) {
                            if(!level.contains(str)) {
                                q.offer(str);
                                level.add(str);
                                List<String> pList = new ArrayList<>();
                                parents.put(str, pList);
                            }
                            List<String> pList = parents.get(str);
                            pList.add(p);
                        }
                        s[i] = old;
                    }
                }
            }
            dict.removeAll(level);
        }
        if(!find) return res;
        getAnswer(new ArrayList<String>(), endWord, beginWord);
        return res;
    }
    private void getAnswer(List<String> temp, String word, String target) {
        temp.add(word);
        if(word.equals(target)) {
            List<String> list = new ArrayList<>(temp);
            Collections.reverse(list);
            res.add(list);
        }else{
            for(String next : parents.get(word)) {
                getAnswer(temp, next, target);
            }
        }
        temp.remove(temp.size()-1);
    }
}

