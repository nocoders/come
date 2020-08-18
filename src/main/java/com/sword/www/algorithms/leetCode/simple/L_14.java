package com.sword.www.algorithms.leetCode.simple;

/**
 * 14查找字符串数组中的最长公共前缀
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
     * 使用 String.startWith()每个判断,
     * 从首字符开始判断，全部成功，再加 一个字符
     * @update https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
     *      看完题解 ，感觉自己代码水平确实差点事，同样思路，我的代码 复杂很多
     *      这个是判断第一个数组每个字符是否同其他数组相同，不相同直接返回。
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
        // 遍历所有的字符串
        for (int i = 0 ; i < strLength; i++) {
            char c = strs[0].charAt(0);
            for (int j = 1; j < length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return  strs[0];
    }


}
