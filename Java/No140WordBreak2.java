import java.util.ArrayList;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */
class No140WordBreak2 {
    private String target;
    private List<String> dict;
    private List<List<String>> log;
    public List<String> wordBreak(String s, List<String> wordDict) {
        target = s;
        dict = wordDict;
        log = new ArrayList<>();
        while(log.size() < s.length()) {
            log.add(null);
        }
        return doSearch(0);
    }
    private List<String> doSearch(int i){
        List<String> list = new ArrayList<>();
        if(i == target.length()) return list;
        if(log.get(i)!=null) return log.get(i);
        String s = target.substring(i);
        for(String word : dict) {
            if(s.startsWith(word)){
                if(s.equals(word)){
                    list.add(word);
                }else{
                    List<String> sub = doSearch(i + word.length());
                    for(String strInSub : sub){
                        list.add(word + " " + strInSub);
                    }
                }
            }
        }
        log.set(i, list);
        return list;
    }
}

