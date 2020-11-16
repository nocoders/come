package com.sword.www.leetCode.simple;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 提示：
 * 0 <= n <= 5 * 106
 * @author linmeng
 * @version 1.0
 * @date 12/11/2020 下午5:30
 */
public class L_204 {

    /**
     * 排除所有质数的倍数,从2开始。
     * @param n
     * @author linmeng
     * @date 12/11/2020 下午5:35
     * @return int
     */
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]){
                res++;
                for (int j = i*2; j < n; j+=i) {
                    isNotPrime[j]=true;
                }
            }
        }
        return res;
    }

}
