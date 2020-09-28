package com.sword.www.leetCode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author linmeng
 * @version 1.0
 * @date 13/8/2020 上午10:39
 */
public class L_242 {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println();
    }
    /**
     * 如果两个两个字符串除了字母异位，元素完全相同，遍历一个字符串，存入map 字符和字符出现数量，
     * 第二个字符串遍历进行数量相减。
     * @param s 字符串1
     * @param t 字符串2
     * @author linmeng
     * @date 13/8/2020 上午10:40
     * @return boolean
     */
    public static boolean isAnagram(String s, String t) {
        int len1 = s.length(),len2 = t.length();
        if (len1 != len2){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>(len1);
        for (int i = 0; i < len1; i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            map.put(c1,map.getOrDefault(c1,0)-1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (0!=entry.getValue()){
                return false;
            }
        }

        return true;
    }
}
