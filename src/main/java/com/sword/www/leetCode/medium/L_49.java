package com.sword.www.leetCode.medium;

import java.util.*;

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
        List<List<String>> lists = groupAnagrams2(strs);
//        StringBuilder stringBuilder = new StringBuilder();

        System.out.println();
    }
    /**
     * 理解：将字符串数组中的字符串按照不排序的情况下字符串中的相等进行分组
     *      使用排序后的字符串为key，集合保存相同字符串数组
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
    /**
     * 遍历每个字符串，将字符串每个字符出现的次数保存到数组中，然后字符跟次数组装成字符串，作为key，value是字符串本身。
     *
     * @param strs
     * @author linmeng
     * @date 2021年3月28日 22:04
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int length = str.length();
            int[] nums = new int[26];
            for (int i = 0; i < length; i++) {
                nums[str.charAt(i)-'a']=nums[str.charAt(i)-'a']+1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(i+'a').append(nums[i]);
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(),list);
        }
        return new ArrayList<>(map.values());
    }

}
