package com.sword.www.leetCode.medium;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author linmeng
 * @version 1.0
 * @date 2021年1月11日 16:06
 */
public class L_454 {

    /**
     * 四个数组两个两个分开，分别求和，第一个求和放到map
     * @param A
     * @param B
     * @param C
     * @param D
     * @author linmeng
     * @date 2021年1月11日 16:13
     * @return int
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int lenA = A.length,lenB = B.length,lenC = C.length,lenD = D.length;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                int sum = A[i]+B[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for (int i = 0; i < lenC; i++) {
            for (int j = 0; j < lenD; j++) {
                int sum = C[i]+D[j];
               if (map.containsKey(-sum)){
                   res+=map.get(-sum);
               }
            }
        }

        return res;
    }
}
