package com.sword.www.algorithms.leetCode.simple;

import java.util.Arrays;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @author linmeng
 * @version 1.0
 * @date 12/8/2020 下午3:15
 */
public class L_7 {
    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println();
    }
    /**
     * int n = n*10 + x%10;
     * x /= 10;
     * @param x
     * @author linmeng
     * @date 12/8/2020 下午4:01
     * @return int
     */
    public static int reverse(int x) {
        if (x==0){
            return x;
        }
        // 使用int会出现问题 n使用double
        double n = 0;
        while (x!=0){
            n = n*10 + x%10;
            x /= 10;
        }
        // 这个地方这样搞就不会精度缺失，不太清楚为什么
        return (int)n==n?(int)n:0;
    }
}
