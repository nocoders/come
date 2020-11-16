package com.sword.www.algorithms.concurrency.charpt2.multiply.task;

/**
 * 每个元素开一个线程
 * @author linmeng
 * @version 1.0
 * @date 24/9/2020 下午4:19
 */
public class IndividualMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int row;
    private final int column;
    public IndividualMultiplierTask(double[][] result, double[][]
            matrix1, double[][] matrix2,
                                    int i, int j) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = i;
        this.column = j;
    }
    @Override
    public void run() {
        result[row][column] = 0;
        for (int k = 0; k < matrix1[row].length; k++) {
            result[row][column] += matrix1[row][k] * matrix2[k][column];
        }
    }
}
