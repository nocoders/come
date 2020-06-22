package com.sword.www.algorithms.leetCode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
* @Description:    leetCode 56 重叠区间合并
* @Author:         linmeng
* @CreateDate:     2020/6/20 17:28
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/20 17:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class L_56 {
    public static void main(String[] args) {
        int [][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(a);
        System.out.println();
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int row = intervals.length;
        int j = 0;
        for(int i=1;i<row;i++){
            int [] a = intervals[j];
            int [] b = intervals[i];
            // 判断前后两个有没有重复
            if((a[0]<b[0] && a[1]>b[0]) || (a[0]>b[0] && a[0]<b[1])){
                a[0] = (a[0]>b[0])?b[0]:a[0];
                int tmp = a[1]>b[0]?a[1]:b[0];
                a[1] = b[1]>tmp?b[1]:tmp;
            }else{
                intervals[++j] = b;
            }
        }
        int [][] res = new int[j+1][2];
        for(int i = 0; i<= j; i++){
            res[i]= intervals[i];
        }
        return res;
    }
}
