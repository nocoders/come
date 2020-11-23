package com.sword.www.leetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * 示例 1:
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * 示例 2:
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * 说明:
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 * @author linmeng
 * @version 1.0
 * @date 2020年11月23日 09:12
 */
public class L_658 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List<Integer> closestElements2 = findClosestElements2(nums, 4, 3);
        System.out.println();
    }
    /**
     * 获取距离x最近的k个数。
     *
     * @param arr
     * @param k
     * @param x
     * @author linmeng
     * @date 2020年11月23日 10:21
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - x) - Math.abs(b - x)).collect(Collectors.toList());
        List<Integer> res = list.subList(0, k);
        Collections.sort(res);
        return res;
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        int size = list.size();
        if (x<=list.get(0)){
            return list.subList(0,k);
        }else if (x>=list.get(size-1)){
            return list.subList(size-k,size);
        }else {
            int index = Collections.binarySearch(list, x);
            if (index<0){
                index = -index - 1;
            }
            int left = Math.max(0,index-k-1),right = Math.min(size-1,index+k-1);
            while (right-left>k-1){
                if (Math.abs(x-list.get(left))>Math.abs(x-list.get(right))){
                    left++;
                }else {
                    right--;
                }
            }
            return list.subList(left,right+1);
        }
    }
}
