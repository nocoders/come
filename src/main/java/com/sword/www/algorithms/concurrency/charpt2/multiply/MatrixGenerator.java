package com.sword.www.algorithms.concurrency.charpt2.multiply;

import java.util.Random;

/**
 * 根据传入的行列值，生成 随机double值的矩阵
 * @author linmeng
 * @version 1.0
 * @date 24/9/2020 下午3:54
 */
public class MatrixGenerator {

    public static double[][] generate(int rows,int columns){
        double[][] res = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res[i][j] = random.nextDouble()*10;
            }
        }

        return res;
    }

}
