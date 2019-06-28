/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */
class No121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curMin = Integer.MAX_VALUE;
        for(int p : prices){
            res = Math.max(res, p-curMin);
            curMin = Math.min(curMin, p);
        }
        return res;
    }
}

