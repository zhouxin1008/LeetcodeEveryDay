import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class No46Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        doPermute(nums, 0);
        return res;
    }

    private void doPermute(int[] nums, int i) {
        if(i == nums.length) {
            List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(temp);
            return;
        }
        for(int j=i; j<nums.length; j++) {
            swap(nums, i, j);
            doPermute(nums, i+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

