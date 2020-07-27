package com.sword.www.algorithms.leetCode.simple;

/**
 * 字符串反转
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/7/27 16:17
 */
public class L_344 {

    public static void main(String[] args) {
        System.out.println("sdfsldf".substring(0));
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
    }
    public static void reverseString(char[] s) {
        int length = s.length,i=0,j=length-1;
        char tmp;
        for(;i<j;i++,j--){
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
