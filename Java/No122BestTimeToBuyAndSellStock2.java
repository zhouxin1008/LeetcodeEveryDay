/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
class No122BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int stock = -1;
        for(int p : prices) {
            if(stock==-1 || stock>=p){
                stock = p;
            }else {
                res += p-stock;
                stock = p;
            }
        }
        return res;
    }
}

