import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */
class No403FrogJump {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(len==1) return true;
        if(stones[1]-stones[0]!=1) return false;
        Map<Integer,Set<Integer>> dp = new HashMap<>();
        for(int i=0; i<len; i++){
            dp.put(i, new HashSet<Integer>());
        }
        dp.get(1).add(1);
        for(int i=2; i<len; i++){
            for(int j=i-1; j>=1; j--){
                int k = stones[i] - stones[j];
                Set<Integer> set = dp.get(j);
                if(set.contains(k-1) || set.contains(k) || set.contains(k+1)){
                    dp.get(i).add(k);
                }
            }
        }
        return dp.get(len-1).size() > 0;
    }
}

