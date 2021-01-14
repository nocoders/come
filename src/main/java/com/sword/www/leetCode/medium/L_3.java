package com.sword.www.leetCode.medium;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月11日 15:08
 */
public class L_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println();
    }
    /**
     * 遍历字符串，使用map key保存字符串中的字符，value保存字符所在的角标 +1
     * 定义两个角标，一个角标代表非重复字符串的第一个字符，另一个角标代表当前遍历到的字符
     * 判断字符在map中是否存在，存在的话替换非重复字符串的第一个字符
     * 将当前字符保存
     * 判断当前非重复字符串最大值
     *
     * @param s
     * @author linmeng
     * @date 2021年1月11日 15:32
     * @return int
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length(),res=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0,j=0; j < length; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)){
                i=Math.max(i,map.get(c));
            }
            map.put(c,j+1);
            res = Math.max(res,j-i+1);
        }

        return res;
    }
}