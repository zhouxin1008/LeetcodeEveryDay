/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class No40CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        doCombinationSum(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }
    private void doCombinationSum(int[] nums, int index, int target, ArrayList<Integer> list) {
        if(target < 0) return;
        if(target == 0) {
            res.add(list);
            return;
        }
        Integer last = null;
        for(int i=index; i<nums.length; i++) {
            int num = nums[i];
            if(last==null || last!=num) {
                last = num;
                ArrayList<Integer> temp = new ArrayList<>(list);
                temp.add(num);
                doCombinationSum(nums, i+1, target - num, temp);
            }
        }
    }
}

