package com.sword.www.algorithms.leetCode.simple;

/**
 * 字符串相加
 *  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * @author linmeng
 * @version 1.0
 * @date 2020/8/3 9:02
 */
public class L_415 {

    public static void main(String[] args) {
        String nums1 = "98",nums2 = "9";
        String s = addStrings(nums1, nums2);
        System.out.println();
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int len1 = num1.length(),len2 = num2.length();
        int len, maxLen;
        String longStr;
        if (len1 > len2){
            len = len2;
            maxLen = len1;
            longStr = num1;
        }else {
            len = len1;
            maxLen = len2;
            longStr = num2;
        }
        int isCarry = 0;
        for (int i = 0; i < len; i++) {
            int tmp = (num1.charAt(len1 - i -1)-'0') + (num2.charAt(len2 - i -1)-'0') + isCarry;
            res.append(tmp%10);
            isCarry = tmp / 10;
        }
        for (int i = len; i < maxLen; i++) {
            int tmp = longStr.charAt(maxLen - 1 - i) - '0' +isCarry;
            res.append(tmp%10);
            isCarry = tmp / 10;
        }
        if (isCarry > 0){
            res.append(isCarry);
        }
        return res.reverse().toString();
    }
}
