package com.sword.www.leetCode.simple;

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == x3
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * 提示：
 * -231 <= n <= 231 - 1
 * @author linmeng
 * @version 1.0
 * @date 13/11/2020 上午11:32
 */
public class L_326 {

    public boolean isPowerOfThree(int n) {
//        return Integer.toString(n, 3).matches("^10*$");
        return n > 0 && 1162261467 % n == 0;
    }
}
