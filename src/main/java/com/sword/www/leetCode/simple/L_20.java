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
    /**
     * 建立一个map，里面以]})为key，[{(为value
     * 遍历字符串，判断map是否有key，没有的话说明是开始的符号，保存到栈里
     * 有的话说明是结束的符号，将出栈的数据同map中对应的value判断是否相等，
     * 不相等返回false，相等返回继续向下执行，直到执行完毕
     * 执行完毕，如果栈为空说明没问题。
     * @param s
     * @author linmeng
     * @date 2020年12月1日 14:13
     * @return boolean
     */
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
