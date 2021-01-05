package com.sword.www.leetCode.simple;


import java.util.*;

/**
 * 387 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author linmeng
 * @version 1.0
 * @date 13/8/2020 上午9:07
 */
public class L_387 {


    public static void main(String[] args) {
        int leetcode = firstUniqChar2("leetcode");
        System.out.println();
    }
    /**
     * 定义一个map，key为
     * @param s
     * @author linmeng
     * @date 13/8/2020 上午9:08
     * @return int
     */
    public static int firstUniqChar(String s) {
        Map<Character,Integer> characters = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
           characters.put(c,characters.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (characters.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 字符串放到map里面，key为字符串角标下的值，value为角标。若存在则把value改为-1。
     * 遍历map判断最小的值返回
     *
     * @param s
     * @author linmeng
     * @date 2021年1月5日 09:02
     * @return int
     */
    public static int firstUniqChar2(String s) {

        Map<Character,Integer> characters = new HashMap<>();
        int len = s.length();
        int index = len;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (characters.containsKey(c)){
                characters.put(c,-1);
            }else {
                characters.put(c,i);
            }
        }
        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            Integer value = entry.getValue();
            index = (value!=-1)?(value<index?value:index):index;
        }

        return index==len?-1:index;
    }
}
