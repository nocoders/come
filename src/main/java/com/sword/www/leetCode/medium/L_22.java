package com.sword.www.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年4月8日 20:44
 */
public class L_22 {
    public static void main(String[] args) {
        L_22 l_22 = new L_22();
        List<String> strings = l_22.generateParenthesis(3);
        System.out.println();
    }
    public List<String> generateParenthesisBack(int n) {
        ArrayList<String> res = new ArrayList<>();
        backTrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    private void backTrack(ArrayList<String> res, StringBuilder sb, int open, int close, int max) {
        if (sb.length()==max*2){
            res.add(sb.toString());
            return;
        }
        if (open<max){
            backTrack(res,sb.append("("),open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open){
            backTrack(res,sb.append(")"),open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /**
         * 括号生成的原则是左边的小括号数量永远大于右边的小括号的数量
         * @param n
         * @author linmeng
         * @date 2021年4月8日 20:45
         * @return java.util.List<java.lang.String>
         */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        int i=0;
        generateAll(new char[2*n],i,res);
        return res;
    }

    private void generateAll(char[] chars, int i, ArrayList<String> res) {
        if (chars.length==i){
            if (valid(chars)){
                res.add(new String(chars));
            }
        }else {
            chars[i]='(';
            generateAll(chars,i+1,res);
            chars[i]=')';
            generateAll(chars,i+1,res);

        }
    }

    private boolean valid(char[] chars) {
        int count=0;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
            } else {
                if (--count < 0) {
                    return false;
                }
            }
        }
        return count==0;
    }
}
