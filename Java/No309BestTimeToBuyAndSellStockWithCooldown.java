/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class No309BestTimeToBuyAndSellStockWithCooldown {
    /**
     * sell[i] = max(sell[i-1], buy[i-1]+price)
     * buy[i] = max(buy[i-1], rest[i-1]-price)
     * rest[i] = sell[i-1]
     * 
     * ==>
     * sell[i] = max(sell[i-1], buy[i-1]+price)
     * buy[i] = max(buy[i-1], sell[i-2]-price)
     */
    public int maxProfit(int[] prices) {
        int sell = 0, preSell = 0, buy = Integer.MIN_VALUE, preBuy = 0;
        for(int price : prices){
            preBuy = buy;
            buy = Math.max(preBuy, preSell-price);
            preSell = sell;
            sell = Math.max(preSell, preBuy+price);
            
        }
        return sell;
    }
}

