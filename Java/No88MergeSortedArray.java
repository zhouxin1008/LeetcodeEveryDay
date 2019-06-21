/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */
class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m--;
        n--;
        while(n>=0 && m>=0 ){
            if(nums1[m]>=nums2[n]){
                nums1[index--] = nums1[m--];
            }else{
                nums1[index--] = nums2[n--];
            }
        }
        while(n >= 0){
            nums1[index--] = nums2[n--];
        }
    }
}

