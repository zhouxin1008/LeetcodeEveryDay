import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */
class No187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++){
            String sub = s.substring(i, i+10);
            if(set.contains(sub)){
                res.add(sub);
            }
            set.add(sub);
        }
        return res.stream().collect(Collectors.toList());
    }
}

