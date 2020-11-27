package com.sword.www.leetCode.medium;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @author linmeng
 * @version 1.0
 * @date 2020年11月27日 10:20
 */
public class L_279 {

    public static void main(String[] args) {
        int i = numSquares(66);
        System.out.println();
    }

    /**
     * 数组dp保存n之前每个元素的最小平方数个数。
     * max_square_index：保存大于n的最小平方数内的所有平方和
     * 遍历n，从1开始，根据dp数组的角标同max_square_index对应
     * @param n
     * @author linmeng
     * @date 2020年11月27日 16:48
     * @return int
     */
    public static int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int sq = (int)Math.sqrt(n)+1;
        int[] sqs = new int[sq];
        for (int i = 0; i < sq; i++) {
            sqs[i] = i * i;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < sqs.length; j++) {
                if (i < sqs[j]){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i-sqs[j]]+1);
            }
        }

        return dp[n];
    }
}
