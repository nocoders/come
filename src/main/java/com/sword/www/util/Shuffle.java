package com.sword.www.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数组集合顺序打乱
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年2月26日 10:10
 */
public class Shuffle {

    public static void arrayShuffle(Integer[] nums){
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        Collections.shuffle(list);

        list.toArray(nums);
    }
}
