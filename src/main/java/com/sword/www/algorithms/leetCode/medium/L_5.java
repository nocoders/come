package com.sword.www.algorithms.leetCode.medium;

/**
 *
 * @TODO 未解决，想不到思路
 * 最长回文子串:使用两个指针进行跑，判断是否相等，不相等直接退出，相等知道前面的指针大于后面的指针，就结束，保存字符串
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/7/6 21:28
 */
public class L_5 {
    public static void main(String[] args) {
//        System.out.println("123".substring(0,1));
//        System.out.println("123".substring(1,2));
        System.out.println(getBeforeStr(0,4,"12345"));
        System.out.println(getAfterStr(0,4,"12345"));
    }
    public void longestPalindrome(String s) {
        int length = s.length();
        String res = "";
        for (int i = 0; i<length-1; i++) {
            int j = i+1;
            while (j<length){
//                if (s.substring(i,(i+j)/2))
            }
        }
    }
    public static String getBeforeStr(int i,int j,String str){
        return str.substring(i,(i+j+1)/2);
    }

    public static String getAfterStr(int i,int j,String str){
        return str.substring((i+j+1)/2,j)+str.charAt(j);
    }
}
