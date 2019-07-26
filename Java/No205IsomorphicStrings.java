import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */
class No205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,List<Integer>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            char c = str[i];
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        str = t.toCharArray();
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            Character c = null;
            for(int i : entry.getValue()){
                if(c == null) {
                    c = str[i];
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }else{
                    if(c != str[i]) return false;
                }
            }
        }
        return true;
    }
}

