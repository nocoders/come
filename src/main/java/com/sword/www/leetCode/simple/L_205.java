package com.sword.www.leetCode.simple;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 提示：
 * 可以假设 s 和 t 长度相同。
 * @author linmeng
 * @version 1.0
 * @date 2020年12月29日 15:35
 */
public class L_205 {

    public static void main(String[] args) {
        String s = "add",t = "egg";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println();
    }

    /**
     * 遍历两个字符串，获取 相同角标下的元素，
     *
     * 定义两个map分别以一个字符串的元素为key，另一个字符串的元素为value
     * 判断两个map中是否包含该key并且该key对应的value是否为另一个字符串的value，不是的话返回false。
     * 是的话，把两个元素作为key value直接保存到map
     *  里面是在判断的同时保存map。这个是没问题的，具体原因我清楚但是说不清楚。
     * @param s
     * @param t
     * @author linmeng
     * @date 2021年1月4日 10:24
     * @return boolean
     */
    public static boolean isIsomorphic(String s, String t) { 
        int length = s.length();
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if ((s2t.containsKey(sChar) && s2t.get(sChar)!=tChar) || (t2s.containsKey(tChar) && t2s.get(tChar)!=sChar)){
                return false;
            }
            s2t.put(sChar,tChar);
            t2s.put(tChar,sChar);
        }

        return true;
    }
    /**
     * 同构字符串，每字符 首次出现、最后出现、指定位出现 索引始终相同
     *
     * @param s
     * @param t
     * @author linmeng
     * @date 2021年1月4日 10:57
     * @return boolean
     */
    public static boolean isIsomorphic2(String s, String t) {
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
