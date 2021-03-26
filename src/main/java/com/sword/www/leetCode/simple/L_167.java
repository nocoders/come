package com.sword.www.leetCode.simple;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/16 10:02
 */
public class L_167 {
    public static void main(String[] args) {
        int [] numbers = {2, 7, 11, 15};
        int[] ints = twoSum2(numbers, 9);
        System.out.println();
    }
    public static int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        if (numbers==null || numbers.length<2){
            return res;
        }
        int length = numbers.length,l,r,mid = 0;
        for (int i = 0; i < length -1; i++) {
           int tmp = target - numbers[i];
           l = i+1;
           r = length;
           while (l<r){
               mid = l + (r-l)/2;
               if (numbers[mid]==tmp){
                   return new int[]{i+1,mid+1};
               }else if (numbers[mid] < tmp){
                   l = mid +1;
               }else {
                   r = mid;
               }
           }
           if (mid<length && numbers[mid] == tmp){
               return new int[]{i+1,mid+1};
           }
        }
        return res;
    }
//    public static int[] twoSum(int[] numbers, int target) {
//        int [] res = new int[2];
//        if (numbers==null || numbers.length<2){
//            return res;
//        }
//        int length = numbers.length;
//        for (int i = 0; i < length -1; i++) {
//            if (target < numbers[i] +numbers[i+1]){
//                return res;
//            }
//            int tmp = target - numbers[i];
//            for (int j = i+1;j<length;j++){
//                if (tmp == numbers[j]){
//                    res[0] = ++i;
//                    res[1] = ++j;
//                    return res;
//                }else if (tmp < numbers[j]){
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 使用双指针，一个最小，一个最大.两者的和小于target就让左边的指针右移，大于target就让右边的指针左移
     *
     * @param numbers
     * @param target
     * @author linmeng
     * @date 2021年3月26日 09:11
     * @return int[]
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int length = numbers.length,i=0,j=length-1;
        while (i<j){
            int sum = numbers[i] + numbers[j];
            if (sum ==target){
                return new int[]{i+1,j+1};
            }else if (sum<target){
                i++;
            }else j--;
        }
        return null;
    }

}
