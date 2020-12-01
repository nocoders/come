package com.sword.www.leetCode.simple;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * @author linmeng
 * @version 1.0
 * @date 2020年12月1日 09:17
 */
public class L_20 {
    public static void main(String[] args) {
        boolean valid = isValid("([)]");
        System.out.println();
    }
    public static boolean isValid(String s) {
        int n = s.length();
        if (n%2==1){
            return false;
        }
        Map<Character, Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty()|| !stack.peek().equals(map.get(c))){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
