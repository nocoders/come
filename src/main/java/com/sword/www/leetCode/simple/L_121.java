package com.sword.www.leetCode.simple;

/**
 * 121 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/8/2 10:57
 */
public class L_121 {

    /**
     *   动态规划，定义一个最小价格，最大收益两个变量，遍历元素，若小于最小价格，最小价格替换，否则计算当前价格同最小价格的收益，
     * 判断是否大于最大收益
     * 20201103 在初级算法里面看到这个方法，又重新想了下，一个变量记录最小元素，一个元素纪录最大元素，遍历时，小于最小元素就把最小元素替换，
     * 大于则同当前的最大元素进行比较，看是否替换 。
     * @param prices
     * @author linmeng
     * @date 2020/8/2 11:11
     * @return int
     */
    public static int maxProfit(int[] prices) {
        if (prices == null ||  prices.length ==0){
            return 0;
        }
        int minPrice = Integer.MAX_VALUE,maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice){
                minPrice = price;
            }else {
                maxProfit = Math.max(price - minPrice ,maxProfit);
            }
        }
        return maxProfit;
    }
}
