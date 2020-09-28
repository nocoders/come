package com.sword.www.leetCode.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/6 21:28
 */
public class L_5 {
    public static void main(String[] args) {
//        System.out.println("123321".substring(0,3));
//        System.out.println("123".substring(1,2));
        String s = longestPalindrome("123321");
        System.out.println();
    }
    /**
     * 指定的字符串，可以从中间扩散判断字符串是否回文，也可以从边缘收缩，感觉从中间扩散好一点
     * @param s
     * @author linmeng
     * @date 2020/7/27 17:19
     * @return void
     */
    public static String longestPalindrome(String s) {
        if (s==null || s.length() == 0){
            return "";
        }
        int length = s.length();
        int firstIndex = 0,lastIndex = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len>(lastIndex - firstIndex)){
                firstIndex = i - (len - 1)/2;
                lastIndex = i + len/2;
            }
            if (len > (length-i+1)*2){
                break;
            }
        }
        return s.substring(firstIndex,lastIndex+1);
    }

    /**
     *
     * @param s 求回文的字符串
     * @param i 中心有可能是一个元素，也有可能是两个元素
     * @param i1 一个元素时同i相等，两个元素时往后 加一
     * @author linmeng
     * @date 2020/7/31 15:37
     * @return int
     */
    private static int expandAroundCenter(String s, int i, int i1) {
        int left = i,right = i1;
        int length = s.length();
        while (left>=0 && right < length && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //  这个地方判断不通过的时候，已经自减自加完成了，减一的原因我也不清楚，但是人家代码没问题，很烦。
        return right-left-1;
    }
}
