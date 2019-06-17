import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
class No77Combinations {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k > n) return res;
        List<Integer> init;
        List<List<Integer>> temp = new ArrayList<>();
        for(int i=1; i<=n-k+1; i++) {
            init = new ArrayList<>();
            init.add(i);
            temp.add(init);
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<temp.size(); j++){
                List<Integer> list = temp.get(j);
                int len = list.size();
                if(len == k) continue;
                if(i > list.get(len-1)){
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i);
                    temp.add(newList);
                }
            }
        }
        for(List<Integer> list : temp) {
            if(list.size() == k) res.add(list);
        }
        return res;
    }
}

