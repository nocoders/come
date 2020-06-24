package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

import com.sword.www.algorithms.fourth.algs4.util.StdOut;
import com.sword.www.algorithms.fourth.algs4.util.StdRandom;

/**
 * 在传入的两个数间随机生成指定个数，作用是测试给main方法传参
 *  点击 run ->Edit configrations->program arguments 这里面能传参数
 * @author 18123
 * @version 1.1
 */
public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double low = Double.parseDouble(args[1]);
        double high = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(low, high);
            StdOut.printf("%.2f\n",x);
        }

    }
}
