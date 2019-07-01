/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */
class No139WordBreak {
    private String target;
    private List<String> dict;
    private boolean[] log;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || wordDict.size()==0) return false;
        target = s;
        dict = wordDict;
        log = new boolean[target.length()+1];
        search(0);
        return log[target.length()];
    }
    private void search(int i){
        if(i==target.length()) {
            log[target.length()] = true;
        }
        if(log[i]==true){
            return;
        }
        log[i] = true;
        String s = target.substring(i);
        for(String str : dict){
            if(s.startsWith(str)){
                search(i+str.length());
            }
        }
    }
}

