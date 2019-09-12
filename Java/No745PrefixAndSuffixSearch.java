import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=745 lang=java
 *
 * [745] Prefix and Suffix Search
 */
class WordFilter {
    private Node prefixRoot = new Node();
    private Node suffixRoot = new Node();
    private Map<String, Integer> map = new HashMap<>();
    private int size;
    class Node {
        Set<String> words = new HashSet<>();
        Node[] childs = new Node[26];
        public Node(){

        }
    }
    public WordFilter(String[] words) {
        this.size = words.length;
        for(int k=0; k<words.length; k++) {
            String word = words[k];
            map.put(word, k);
            Node it = prefixRoot;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(it.childs[c-'a'] == null) {
                    it.childs[c-'a'] = new Node();
                }
                it = it.childs[c-'a'];
                it.words.add(word);
            }
            it = suffixRoot;
            for(int i=word.length()-1; i>=0; i--) {
                char c = word.charAt(i);
                if(it.childs[c-'a'] == null) {
                    it.childs[c-'a'] = new Node();
                }
                it = it.childs[c-'a'];
                it.words.add(word);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Set<String> set1 = null;
        Set<String> set2 = null;
        Node it;
        if(!prefix.trim().isEmpty()){
            it = this.prefixRoot;
            for(char c : prefix.toCharArray()){
                it = it.childs[c-'a'];
                if(it == null) break;
            }
            set1 = it == null ? new HashSet<>(): it.words;
        }
        if(!suffix.trim().isEmpty()) {
            it = this.suffixRoot;
            for(int i=suffix.length()-1; i>=0; i--) {
                it = it.childs[suffix.charAt(i)-'a'];
                if(it == null) break;
            }
            set2 = it == null ? new HashSet<>(): it.words;
        }
        if(set1==null && set2==null) {
            return this.size - 1;
        }
        if((set1!=null && set1.isEmpty()) || (set2!=null && set2.isEmpty())) {
            return -1;
        }
        int max = -1;
        if(set1 != null) {
            for(String i : set1) {
                if(set2==null || set2.contains(i)) {
                    max = Math.max(map.get(i), max);
                }
            }
            return max;
        }
        if(set2 != null) {
            for(String i : set2) {
                if(set1==null || set1.contains(i)) {
                    max = Math.max(map.get(i), max);
                }
            }
            return max;
        }
        return max;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

