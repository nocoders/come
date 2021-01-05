package com.sword.www.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月5日 17:18
 */
public class L_49 {

    public static void main(String[] args) {
        String [] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println();
    }
    /**
     * 理解：将字符串数组中的字符串按照不排序的情况下字符串中的相等进行分组
     * @param strs
     * @author linmeng
     * @date 2021年1月5日 17:19
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }

        return new ArrayList<>(map.values()) ;
    }
}
