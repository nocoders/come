package com.sword.www.algorithms.concurrency.charpt2.multiply.task;

/**
 * 根据系统处理器数量决定开启线程数量
 * @author linmeng
 * @version 1.0
 * @date 25/9/2020 上午10:48
 */
public class GroupMultiplierTask implements Runnable{
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int startIndex;
    private final int endIndex;
    public GroupMultiplierTask(double[][] result, double[][]
            matrix1, double[][] matrix2,
                               int startIndex, int endIndex) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j]=0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
    }
}
