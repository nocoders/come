package com.sword.www.algorithms.leetCode.simple;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author linmeng
 * @version 1.0
 * @date 13/8/2020 下午2:36
 */
public class L_125 {


    public static void main(String[] args) {
        char a = '0',b = '9';
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println('Z');
    }
    /**
     * 判断回文字符串，不区分大小写.a=97,z=122,A=65,Z=90
     * 1、把字符串全部变成小写，
     * 2、判断字符串是否在字母范围内，不在继续走
     * 3、判断两字符是否相等
     *
     * @param s
     * @author linmeng
     * @date 13/8/2020 下午2:37
     * @return boolean
     */
    public static boolean isPalindrome(String s) {

        char[] chars = s.toLowerCase().toCharArray();
        int i=0,len=chars.length,j=len-1;
        for (; i<j; i++,j--) {
            while ((chars[i]<48 || (chars[i]>57&&chars[i]<97) || chars[i]>122) && i<j){
                i++;
            }
            while ((chars[j]<48 || (chars[j]>57&&chars[j]<97) || chars[j]>122) && i<j){
                j--;
            }
            if (chars[i]!=chars[j]){
                return false;
            }
        }
        return true;
    }
}
