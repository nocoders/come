package com.sword.www.leetCode.simple;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * @author linmeng
 * @version 1.0
 * @date 2020/7/30 15:09
 */
public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows <= 0){
            return new ArrayList<>();
        }
        List<Integer> previousList = new ArrayList<>(),tmpList;
        for (int i = 0; i < numRows; i++) {
            tmpList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
               if (j==0 || j == i){
                   tmpList.add(1);
               }else {
                   tmpList.add(previousList.get(j-1)+previousList.get(j));
               }
            }
            res.add(previousList = tmpList);
        }
        return res;
    }
}
