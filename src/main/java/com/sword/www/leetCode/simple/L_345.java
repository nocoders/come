package com.sword.www.leetCode.simple;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 提示：
 * 元音字母不包含字母 "y" 。
 * @author linmeng
 * @version 1.0
 * @date 2021年3月26日 09:50
 */
public class L_345 {

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'z');
    }
    /**
     * 双指针
     * @param s
     * @author linmeng
     * @date 2021年3月26日 09:52
     * @return java.lang.String
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length,i=0,j=length-1;
        while (i<j){
            if (!isVowel(chars[i])){
                i++;
            }
            if (!isVowel(chars[j])){
                j--;
            }
            if (isVowel(chars[i])&&isVowel(chars[j])){
                swap(chars,i,j);
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }
    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    boolean isVowel(char c) {
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }
}
