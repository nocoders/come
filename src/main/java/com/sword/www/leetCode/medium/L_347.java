package com.sword.www.leetCode.medium;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * @author linmeng
 * @version 1.0
 * @date 2021年1月11日 16:18
 */
public class L_347 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        int[] ints1 = topKFrequentFx(ints, 2);
        System.out.println();
    }
    /**
     * 1 使用map把保存元素值以及元素出现的次数
     * 2 使用优先队列根据元素次数排序，保留次数最多的k个值
     * 3 返回
     * @param nums
     * @param k
     * @author linmeng
     * @date 2021年1月11日 19:45
     * @return int[]
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            int[] ints = {key, value};
            if (queue.size()==k){
                int[] poll = queue.poll();
                queue.offer(poll[1]>value?poll: ints);
            }else {
                queue.offer(ints);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll()[0];
        }
        return res;
    }
    
    /**
     * 使用{@link java.util.TreeMap<Integer,Integer>}保存各元素数量
     * @param nums
     * @param k
     * @author linmeng
     * @date 2021年5月7日 17:17
     * @return int[]
     */
    public static int[] topKFrequentFx(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt( o ->o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size()==k){
                int[] ints = queue.poll();
                queue.add(ints[1]>entry.getValue()?ints:new int[]{entry.getKey(),entry.getValue()});
            }else {
                queue.add(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        Integer [] res = new Integer[k];

        return queue.stream().mapToInt(a->a[0]).toArray();
    }
    /**
     * 
     * 直接使用lambda表达式解决
     * @param nums
     * @param k 
     * @author linmeng
     * @date 2021年5月10日 21:30 
     * @return int[]
     */
    public static int[] topKFrequentFx2(int[] nums, int k) {

        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k).mapToInt(Map.Entry::getKey).toArray();
    }
}
