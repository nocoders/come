package com.sword.www.leetCode.simple;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @author linmeng
 * @version 1.0
 * @date 2020年12月28日 11:05
 */
public class L_202 {

    public static void main(String[] args) {
        boolean happy = isHappy(10);
        System.out.println();
    }
    static int squareSum(int n){
        int num = n,res=0;
        while (num>0){
            int tmp = num%10;
            res += tmp*tmp;
            num /= 10;
        }

        return res;
    }

    public static boolean isHappy(int n) {
        int slow = n,fast = n;
        while (slow!=1 && fast!=1){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (slow==fast && slow!=1 && fast!=1){
                return false;
            }
        }

        return true;
    }
}