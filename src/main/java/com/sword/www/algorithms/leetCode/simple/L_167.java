package com.sword.www.algorithms.leetCode.simple;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/16 10:02
 */
public class L_167 {
    public static void main(String[] args) {
        int [] numbers = {2, 7, 11, 15};
        int[] ints = twoSum(numbers, 9);
        System.out.println();
    }
    public static int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        if (numbers==null || numbers.length<2){
            return res;
        }
        int length = numbers.length;
        for (int i = 0; i < length -1; i++) {
            if (target < numbers[i] +numbers[i+1]){
                return res;
            }
            int tmp = target - numbers[i];
            for (int j = i+1;j<length;j++){
                if (tmp == numbers[j]){
                    res[0] = ++i;
                    res[1] = ++j;
                    return res;
                }else if (tmp < numbers[j]){
                    break;
                }
            }
        }
        return res;
    }
}
