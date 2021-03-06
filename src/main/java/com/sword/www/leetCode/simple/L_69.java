package com.sword.www.leetCode.simple;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @author linmeng
 * @version 1.0
 * @date 13/11/2020 下午3:00
 */
public class L_69 {

    public static void main(String[] args) {
        int i = mySqrt(2147395599);
        System.out.println();
    }
    public static int mySqrt(int x) {
        if (x==1){
            return 1;
        }
        long tmp = 0,mid = 0,first = 0,last = x/2;
        while (first<=last){
            mid =(long) first + (last-first)/2;
           tmp = mid * mid;
            if (tmp<x){
                first = mid+1;
            }else if (tmp>x){
                last = mid-1;
            }else {
                return (int)mid;
            }
        }
        if (tmp<x && (mid+1)*(mid+1)>x){
            return (int)mid;
        }
        if (tmp>x && (mid-1)*(mid-1)<x){
            return (int)mid-1;
        }
        return -1;
    }
}
