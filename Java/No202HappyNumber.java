import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */
class No202HappyNumber {
    public boolean isHappy(int n) {
        Set<String> set = new HashSet<>();
        String cur = String.valueOf(n);
        while (!set.contains(cur)) {
            set.add(cur);
            int sum = 0;
            for(char c : cur.toCharArray()){
                int num = c-'0';
                sum += num*num;
            }
            if(sum==1) return true;
            cur = String.valueOf(sum);
        } 
        return false;
    }
}

