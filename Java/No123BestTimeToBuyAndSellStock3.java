/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */
class No123BestTimeToBuyAndSellStock3 {
    private int[] dpLeft;
    private int[] dpRight;
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int len = prices.length;
        dpLeft = new int[len];
        dpRight = new int[len];
        buildDpLeft(prices, len);
        buildDpRight(prices, len);
        int res = 0;
        for(int i=1; i<len-2; i++){
            res = Math.max(dpLeft[i]+dpRight[i+1], res);
        }
        res = Math.max(res, dpLeft[len-1]);
        return res;
    }

    private void buildDpLeft(int[] prices, int len) {
        int min = prices[0];
        for(int i=0; i<len; i++){
            if(i==0) {
                dpLeft[i] = 0;
            } else {
                dpLeft[i] = Math.max(dpLeft[i-1], prices[i]-min);
                min = Math.min(min, prices[i]);
            }
        }
    }
    private void buildDpRight(int[] prices, int len) {
        int max = prices[len-1];
        for(int i=len-1; i>=0; i--){
            if(i==len-1) {
                dpRight[i] = 0;
            } else {
                dpRight[i] = Math.max(dpRight[i+1], max - prices[i]);
                max = Math.max(max, prices[i]);
            }
        }
    }
}

