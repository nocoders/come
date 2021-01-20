package com.sword.www.util;

import com.sword.www.leetCode.bean.TreeNode;
import com.sword.www.leetCode.medium.L_106;

/**
 * TODO
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月20日 11:24
 */
public class LeetCodeTestUtil {
    public static void main(String[] args) {
        L_106 l_106 = new L_106();
        int[] ins = {9,3,15,20,7},posts = {9,15,7,20,3};
        TreeNode node = l_106.buildTree(ins, posts);
        System.out.println();
    }
}
