package com.sword.www.leetCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * @author linmeng
 * @version 1.0
 * @date 12/11/2020 下午4:12
 */
public class L_412 {

    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>(n);
        String str1 = "Fizz", str2 = "Buzz", str3 = "FizzBuzz";
        boolean fizzRes, buzzRes;
        for (int i = 1; i <= n; i++) {
            fizzRes = i % 3 == 0;
            buzzRes = i % 5 == 0;
            if (fizzRes && buzzRes) {
                res.add(str3);
            } else if (fizzRes) {
                res.add(str1);
            } else if (buzzRes) {
                res.add(str2);
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
