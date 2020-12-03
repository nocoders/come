package com.sword.www.leetCode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月1日 14:12
 */
public class L_739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(temperatures);

        System.out.println();
    }
    /**
     * 使用栈保存未找到比他大的元素的角标，
     * 遍历数组，判断栈是否为空，不为空遍历，判断栈中的元素是否小于当前元素，小于当前元素计算相隔距离
     *
     * @param T
     * @author linmeng
     * @date 2020年12月2日 16:09
     * @return int[]
     */
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer>stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && T[stack.peek()]<temperature){
                Integer preIndex = stack.pop();
                ans[preIndex] = i-preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
