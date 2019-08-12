/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */
class No367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int left = 0, right = num/2;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(num/mid <= mid) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left*left == num;
    }
}

