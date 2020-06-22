package com.sword.www.algorithms.fourth.algs4.util;

import com.sword.www.algorithms.fourth.algs4.bean.SortEnum;
import com.sword.www.algorithms.fourth.algs4.bean.StopWatch;
import com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1.InsertSort;
import com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1.SelectionSort;
import com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1.ShellSort;

/**
* @Description:
* @Author:         linmeng
* @CreateDate:     2020/6/20 13:35
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/20 13:35
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SortTest {

    public static void main(String[] args) {
        double v = timeRandomInput(SortEnum.SELECT, 10000, 10);
        double v2 = timeRandomInput(SortEnum.INSERT, 10000, 10);
        double v3 = timeRandomInput(SortEnum.SHELL, 10000, 10);
        System.out.println("v:"+v+",v2:"+v2+",v3:"+v3);
    }

    public static double time(SortEnum sortEnum,Comparable[] a){
        StopWatch time = new StopWatch();
        if (sortEnum.equals(SortEnum.SELECT)){
            SelectionSort.sort(a);
        }
        if (sortEnum.equals(SortEnum.INSERT)){
            InsertSort.sort(a);
        }
        if (sortEnum.equals(SortEnum.SHELL)){
            ShellSort.sort(a);
        }
        return time.elapsedTime();
    }

    /**
     * 根据传入排序的枚举，选定排序方法求排序的时间和
     * @param sortEnum 枚举，决定使用哪种排序方法
     * @param T 一次排序时间可能有偏差，多次重复排序使用多次排序时间的和
     * @param N 排序数组的长度
     * @return 返回多次排序时间的和
     */
    public static double timeRandomInput(SortEnum sortEnum,int N,int T){
        double total = 0.0;
        Double [] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(sortEnum, a);
        }
        return total;
    }
}
