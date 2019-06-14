/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class No52NQueens2 {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        generateSolution(new int[0], n);
        return res;
    }
    private void generateSolution(int[] nums, int n) {
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
            res++;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        for(int i=0; i<n; i++) {
            if(!set.contains(i)) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(i);
                int[] next = temp.stream().mapToInt(it->it).toArray();
                generateSolution(next, n);
            }
        }
    }
}

