import java.util.HashMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private String getKey(String s) {
        int[] mark = new int[26];
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            mark[index] = mark[index] + 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<mark.length; i++) {
            if(mark[i] != 0) {
                char c = (char)(i + 'a');
                sb.append(c);
                sb.append(mark[i]);
            }
        }
        return sb.toString();
    }
}

