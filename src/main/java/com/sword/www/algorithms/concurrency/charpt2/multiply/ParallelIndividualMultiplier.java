package com.sword.www.algorithms.concurrency.charpt2.multiply;

import com.sword.www.algorithms.concurrency.charpt2.multiply.task.IndividualMultiplierTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author linmeng
 * @version 1.0
 * @date 24/9/2020 下午5:10
 */
public class ParallelIndividualMultiplier {
    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(1000, 1000);
        double matrix2[][] = MatrixGenerator.generate(1000, 1000);
        double resultSerial[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date start=new Date();
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Parallel: %d%n",end.getTime()-start.getTime());

    }
    public static void multiply(double[][] matrix1, double[][] matrix2,
                                double[][] result) {
        List<Thread> threads=new ArrayList<>();
        int rows1=matrix1.length;
        int column2=matrix2.length;
        for (int i=0; i<rows1; i++) {
            for (int j=0; j<column2; j++) {
                IndividualMultiplierTask task=new IndividualMultiplierTask
                        (result, matrix1, matrix2, i, j);
                Thread thread=new Thread(task);
                thread.start();
                threads.add(thread);
                if (threads.size() % 10 == 0) {
                    waitForThreads(threads);
                }
            }
        }
    }
    private static void waitForThreads(List<Thread> threads){
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
