/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class No4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = len/2;
        if(len%2==0){
            int a = findKth(nums1, nums2, k, 0, 0);
            int b = findKth(nums1, nums2, k+1, 0, 0);
            return (double)(a+b)/2;
        }else{
            return (double)findKth(nums1, nums2, k+1, 0, 0);
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k, int left1, int left2){
        if(left1 == nums1.length) return nums2[left2+k-1];
        if(left2 == nums2.length) return nums1[left1+k-1];
        if(k==1) return nums1[left1] < nums2[left2] ? nums1[left1] : nums2[left2];
        int mid = k/2;
        int right1 = left1+mid-1 >= nums1.length ? nums1.length-1 : left1+mid-1;
        int right2 = left2+mid-1 >= nums2.length ? nums2.length-1 : left2+mid-1;
        if(nums1[right1] < nums2[right2]){
            return findKth(nums1, nums2, k-(right1-left1+1), right1+1, left2);
        }else{
            return findKth(nums1, nums2, k-(right2-left2+1), left1, right2+1);
        }
    }
}

