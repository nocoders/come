package com.sword.www.algorithms.leetCode.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * @author linmeng
 * @version 1.0
 * @date 2020/7/30 15:09
 */
public class PascalTriangle2 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static List<Integer> getRow(int numRows) {
        if (numRows<0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        long pre = 1L;
        res.add(1);
        for (int i = 1; i <= numRows; i++) {
            pre = (pre * (numRows - i +1) / i);
            res.add((int) pre);
        }
        return res;
    }
}
