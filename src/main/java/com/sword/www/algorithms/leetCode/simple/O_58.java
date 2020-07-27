package com.sword.www.algorithms.leetCode.simple;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/7/27 16:35
 */
public class O_58 {

    public String reverseLeftWords(String s, int n) {
//        return s.substring(n,s.length()) + s.substring(0,n);
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = n; i < length + n; i++) {
            sb.append(s.charAt(i%length));
        }
        return sb.toString();
    }
}
