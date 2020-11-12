package com.sword.www.leetCode.simple;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author linmeng
 * @version 1.0
 * @date 29/10/2020 下午5:15
 */
public class L_70 {

    /**
     * 下楼梯是典型的斐波那契数列，第n阶上去的方法数量 = 第n-1阶的方法数量 + 第n-2阶的方法数量
     *
     * @param n
     * @author linmeng
     * @date 12/11/2020 下午3:58
     * @return int
     */
    public int climbStairs(int n) {
        int f0 = 0,f1 = 1,fn = 0;
        for (int i = 0; i < n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
