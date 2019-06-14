/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class No60PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = i+1;
        }
        int[] factorial = new int[n];
        for(int i=0; i<n; i++){
            if(i==0) factorial[i] = nums[i];
            else factorial[i] = nums[i] * factorial[i-1];
        }
        StringBuilder sb = new StringBuilder();
        int index = n - 1;
        while(index >= 0) {
            int a = k / (factorial[index]/(index+1));
            if (a != 0) {
                int b = k % (factorial[index]/(index+1));
                if(b == 0) a = a-1;
            }
            int temp = a;
            for(int i=0; i<n; i++) {
                if(nums[i]!=0) {
                    if(temp!=0) temp--;
                    else {
                        sb.append(nums[i]);
                        nums[i] = 0;
                        break;
                    }
                }
            }
            k = k - a*(factorial[index]/(index+1));
            index--;
        }
        return sb.toString();
    }
}

