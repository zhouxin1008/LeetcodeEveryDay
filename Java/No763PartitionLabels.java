import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */
class No763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        List<Integer> indecies = new ArrayList<>();
        for(int i=0; i<S.length(); i++) {
            map[S.charAt(i) - 'a'] = i; 
        }
        int cur_max = 0;
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            cur_max = Math.max(cur_max, map[c - 'a']);
            if(cur_max == i) {
                indecies.add(cur_max + 1);
            }
        }
        for(int i=0; i<indecies.size(); i++) {
            if(i == 0) res.add(indecies.get(i));
            else res.add(indecies.get(i) - indecies.get(i-1));
        }
        return res;
    }
}

