import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums==null || nums.length==0) return res;
        for(int n : nums) {
            int len = res.size();
            for(int i=0; i<len; i++){
                List<Integer> list = res.get(i);
                List<Integer> temp = new ArrayList<Integer>(list);
                temp.add(n);
                res.add(temp);
            }
        }
        return res;
    }
}

