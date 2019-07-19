import java.util.ArrayList;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */
class No216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<10; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            doSearch(list, i, k, n, res);
        }
        return res;
    }

    private void doSearch(List<Integer> list, int sum, int k, int n, List<List<Integer>> res) {
        int size = list.size();
        if(sum==n && size == k){
            res.add(list);
            return;
        }
        if(sum >= n) return;
        int last = list.get(size-1);
        if(size == k || last == 9) return;
        for(int i=last+1; i<10; i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            doSearch(newList, sum+i, k, n, res);
        }  
    }
}

