package com.sword.www.algorithms.leetCode.simple;

/**
 * 查找字符串数组中的最长公共前缀
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/7/2 21:27
 */
public class L_14 {

    public static void main(String[] args) {
        String [] strs = {"aa","ac"};
        String s = longestCommonPrefix(strs);
        System.out.println("123".substring(0,0));
    }
    /**
     * 使用 String.startWith()每个判断
     *
     * @param strs 传入字符串数组
     * @author linmeng
     * @date 2020/7/2 21:28
     * @return java.lang.String 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0||strs[0].length() == 0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        int length = strs.length;
        int strLength = strs[0].length();
        // 前缀
        String prefix = strs[0].substring(0,1);
        boolean isTrue = true;
        // 遍历所有的字符串
        for (int i = 0 ; i < strLength; i++) {
            for (int j = 1; j < length; j++) {
                if (!strs[j].startsWith(prefix)){
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                if (i<strLength-1){
                    prefix = prefix + strs[0].charAt(i+1);
                }else {
                    return prefix;
                }
            }else {
                return prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
