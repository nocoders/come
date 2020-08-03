package com.sword.www.algorithms.leetCode.simple;

/**
 * 买卖股票的最佳时机||
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/8/2 10:57
 */
public class L_122 {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println();
    }
    /**
     * 这个可以进行多笔交易，我们需要判断股票趋势，若下一个元素是比 上一个元素小的时候，我们在上一个元素就卖出股票
     *
     * @param prices
     * @author linmeng
     * @date 2020/8/3 10:59
     * @return int
     */
    public static int maxProfit(int[] prices) {
        if (prices == null ||  prices.length ==0){
            return 0;
        }
        int length = prices.length;
        int minPrice = Integer.MAX_VALUE,maxProfit = 0,res = 0;
        for (int i = 0;i<length;i++) {
            int price = prices[i];
            if (price < minPrice){
                minPrice = price;
            }else {
                maxProfit = Math.max(price - minPrice ,maxProfit);
            }
            // 判断下一个元素是往下走还是往上走，往下走判断当前是否有盈利，有盈利就卖，卖了之后最小价格设置为当天价格
            if (i < length-1 && price > prices[i+1] && maxProfit > 0){
                res += maxProfit;
                minPrice = price;
                maxProfit = 0;
            }
        }
        return res+maxProfit;

    }
}
