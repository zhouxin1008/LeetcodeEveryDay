import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */
class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int dis = 1;
        while(!reached.contains(endWord)){
            Set<String> toReach = new HashSet<>();
            for(String str1 : reached) {
                for(String str2 : dict) {
                    if(canReach(str1, str2)){
                        toReach.add(str2);
                    }
                }
            }
            if(toReach.size()==0) return 0;
            dict.removeAll(toReach);
            reached = toReach;
            dis++;
        }
        return dis;
    }

    private boolean canReach(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        int diff = 0;
        for(int i=0; i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

