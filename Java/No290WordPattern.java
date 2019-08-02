import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
class No290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length){
            return false;
        }
        Map<Object,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < pattern.length();i++){
            if(!Objects.equals(hashMap.put(pattern.charAt(i),i),hashMap.put(strings[i],i))){
                return false;
            }
        }
        return true;
    }
}

