/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */
class No211AddAndSearchWord {

    private TrieNode root;

    class TrieNode {
        TrieNode[] next;
        boolean isWord;

        public TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new TrieNode();
            }
            node = node.next[c-'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null || word.isEmpty()) return true;
        return search(word.toCharArray(), root, 0);
    }

    private boolean search(char[] word, TrieNode node, int index) {
        if(node == null) return false;
        if(index == word.length){
            return node.isWord;
        }
        char c = word[index];
        if(c == '.') {
            for(int i=0; i<26; i++) {
                if(search(word, node.next[i], index+1)){
                    return true;
                }
            }
            return false;
        } else {
            return search(word, node.next[c-'a'], index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

