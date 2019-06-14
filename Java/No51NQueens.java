import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class No51NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<int[]> res = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        generateIntSolution(res, new int[0], n);
        for(int[] nums : res) {
            result.add(generateStringSolution(nums));
        }
        return result;
    }

    private void generateIntSolution(List<int[]> res, int[] nums, int n) {
        int len = nums.length;
        if(len > 1) {
            int last = nums[len-1];
            for(int i=len-2; i>=0; i--) {
                int temp = nums[i];
                if(temp+i == last+len-1 || temp-i == last-len+1){
                    return;
                }
            }
        }
        if(len == n) {
            res.add(nums);
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        for(int i=0; i<n; i++) {
            if(!set.contains(i)) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(i);
                int[] next = temp.stream().mapToInt(it->it).toArray();
                generateIntSolution(res, next, n);
            }
        }
    }

    private List<String> generateStringSolution(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        char[] temp = new char[n];
        for(int num : nums) {
            Arrays.fill(temp, '.');
            temp[num] = 'Q';
            res.add(new String(temp));
        }
        return res;
    }
}

