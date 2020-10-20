package com.sword.www.algorithms.concurrency.charpt2.multiply;

import com.sword.www.algorithms.concurrency.charpt2.multiply.task.GroupMultiplierTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 根据服务器的处理器数量确定线程数量
 * @author linmeng
 * @version 1.0
 * @date 27/9/2020 下午3:12
 */
public class ParallelGroupMultiplier {
    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(1000, 1000);
        double[][] matrix2 = MatrixGenerator.generate(1000, 1000);
        double resultSerial[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date start=new Date();
        ParallelGroupMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Group: %d%n",end.getTime()-start.getTime());
    }
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result) {
        List<Thread> threads=new ArrayList<>();
        int rows1=matrix1.length;
        int numThreads=Runtime.getRuntime().availableProcessors();
        int startIndex, endIndex, step;
        step=rows1 / numThreads;
        startIndex=0;
        endIndex=step;
        for (int i=0; i<numThreads; i++) {
            GroupMultiplierTask task=new GroupMultiplierTask
                    (result, matrix1, matrix2, startIndex, endIndex);
            Thread thread=new Thread(task);
            thread.start();
            threads.add(thread);
            startIndex=endIndex;
            endIndex= i==numThreads-2?rows1:endIndex+step;
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
