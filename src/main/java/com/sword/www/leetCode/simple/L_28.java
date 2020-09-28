package com.sword.www.leetCode.simple;

import java.util.Arrays;

/**
 *实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author linmeng
 * @version 1.0
 * @date 17/8/2020 下午9:39
 */
public class L_28 {

    public static void main(String[] args) {
        String str = "abcdabca";
        int[] nextArray = getNextArray(str);
        System.out.println(Arrays.toString(nextArray));
    }
    public static int strStr(String haystack, String needle) {

        return -1;
    }

    public static int[] getNextArray(String str){
        int len = str.length();
        int[] res = new int[len];
        for (int i = 1,j = 0; i < len; i++) {
            if (str.charAt(i)==str.charAt(j)){
                j++;
                res[i] = j;
            }
            j = 0;
        }
        return res;
    }
}
