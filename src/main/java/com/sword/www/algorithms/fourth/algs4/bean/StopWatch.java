package com.sword.www.algorithms.fourth.algs4.bean;
/**
* @Description:    获取排序执行时间
* @Author:         linmeng
* @CreateDate:     2020/6/20 12:57
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/20 12:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class StopWatch {

    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}
