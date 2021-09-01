package com.sword.www.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        int[][] merge = mergeFx(a);
        System.out.println();
    }
    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals 传入的重叠的数组
     * @author linmeng
     * @date 2020/6/28 11:46 
     * @return int[][]
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int row = intervals.length;
        int j = 0;
        for(int i=1;i<row;i++){
            int [] a = intervals[j];
            int [] b = intervals[i];
            // 判断前后两个有没有重复
            if((a[0]<b[0] && a[1]>b[0]) || (a[0]>b[0] && a[0]<b[1])){
                a[0] = Math.min(a[0], b[0]);
                int tmp = Math.max(a[1], b[0]);
                a[1] = Math.max(b[1], tmp);
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
    public static int[][] mergeFx(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int length = intervals.length;
        int [] tmp = new int[2];
        List<int[]> ints = new ArrayList<>();
        for(int i=1,j=0;i<length;){
             tmp=intervals[j];
            while(i<length && tmp[1]>=intervals[i][0]){
                tmp[1]=intervals[i][1];
                i++;
            }
            ints.add(tmp);
            j=i++;
        }
        if (tmp[1]<intervals[length-1][0]){
            ints.add(intervals[length-1]);
        }
        int[][] res = new int[ints.size()][2];
        return ints.toArray(res);
    }
}
