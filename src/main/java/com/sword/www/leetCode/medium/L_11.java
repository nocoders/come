package com.sword.www.leetCode.medium;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年3月28日 09:34
 */
public class L_11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println();
    }
    /**
     * 滑动窗口， 取数组首尾两个角标（l,r).获取面积作为最大面积，然后循环获取面积如果比最大面积大，就替换最大面积
     * 如果左边高度高，右边角标减一，右边高度高，左边角标减一。
     * 循环结束条件是左边角标大与右边角标。
     *
     * @param height
     * @author linmeng
     * @date 2021年3月28日 09:34
     * @return int
     */
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1,maxArea = 0;
        while (l<r){
            maxArea = Math.max(Math.min(height[l],height[r])*(r-l),maxArea);
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxArea;
    }
}
