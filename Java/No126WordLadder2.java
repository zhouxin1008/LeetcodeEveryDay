import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
class No126WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if(!wordDict.contains(endWord)) return new ArrayList<List<String>>();
        wordDict.remove(beginWord);
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        Map<String,List<List<String>>> map = new HashMap<>();
        List<List<String>> init = Arrays.asList(Arrays.asList(beginWord));
        map.put(beginWord, init);
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            List<List<String>> list1 = map.get(each);
                            List<List<String>> list2 = map.getOrDefault(word, new ArrayList<List<String>>());
                            for(List<String> sub : list1) {
                                List<String> temp = new ArrayList<>(sub);
                                temp.add(word);
                                list2.add(temp);
                            }
                            map.put(word, list2);
                        }
                    }
                }
            }
            if (toAdd.size() == 0) return new ArrayList<List<String>>();
            wordDict.removeAll(toAdd);
            reached = toAdd;
        }
        return map.getOrDefault(endWord, new ArrayList<List<String>>());
    }
}

