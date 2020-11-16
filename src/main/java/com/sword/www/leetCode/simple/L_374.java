package com.sword.www.leetCode.simple;

/**
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 示例 1：
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * 输入：n = 2, pick = 2
 * 输出：2
 * 提示：
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * @author linmeng
 * @version 1.0
 * @date 16/11/2020 上午9:44
 */
public class L_374 {

    private static int n = 6;

    public static void main(String[] args) {
        int i = guessNumber(10);
        System.out.println();
    }
    static int guess(int num){
        if (num == n){
            return 0;
        }

        return n>num?1:-1;
    }

    public static int guessNumber(int n) {
        int first = 1,last = n,mid;
        while (first<=last){
            mid = first + (last-first)/2;
            int guess = guess(mid);
            if (guess ==0){
                return mid;
            }else if (guess<0){
                last = mid+1;
            }else {
                first = mid-1;
            }
        }

        return n;
    }
}
