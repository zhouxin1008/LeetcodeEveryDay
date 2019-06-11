/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
class No39CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for(int i=index; i<nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);
            doCombinationSum(nums, i, target - nums[i], temp);
        }
    }
}

