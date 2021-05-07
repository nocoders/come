package com.sword.www.leetCode.medium;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年2月22日 14:40
 */
public class L_75 {

    public static void main(String[] args) {
        int[]nums = new int[]{2,0,1};
        sortColorsFx(nums);
        System.out.println();
    }
    /**
     * 单指针两次遍历，定义一个指针，从零开始。
     * 开始第一次遍历，等于零就同指针下的元素进行替换，指针递增
     * 开始第二次遍历，等于一就同指针下的元素进行替换，指针递增
     * @param nums
     * @author linmeng
     * @date 2021年2月22日 14:51
     * @return void
     */
    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
        int index=0,length=nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i]==0){
                swap(i,index,nums);
                index++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i]==1){
                swap(i,index,nums);
                index++;
            }
        }
    }

    /**
     * 双指针进行遍历，定义两个指针p0=0，p1=0，
     * 遍历数组，首先判断当前元素是否等于1，等于1的话就将数组元素同p1元素进行替换，p1自增
     * 然后判断当前元素是否等于0，等于零的话，将p0下的元素同数组遍历元素替换，
     *      判断p1是否大于p0，大于p0的话说明p0替换的元素是1，再将数组元素同p1进行替换
     * @param nums
     * @author linmeng
     * @date 2021年2月22日 16:00
     * @return void
     */
    public static void sortColors2(int[] nums) {
        int p0=0,p1=0,length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i]==1){
                int tmp =  nums[i];
                nums[i]=nums[p1];
                nums[p1]=tmp;
                p1++;
            }else if (nums[i]==0){
                int tmp = nums[i];
                nums[i]=nums[p0];
                nums[p0]=tmp;
                if (p0<p1){
                    tmp =nums[i];
                    nums[i]=nums[p1];
                    nums[p1]=tmp;
                }
                p0++;
                p1++;
            }
        }
    }
    private static void swap(int i, int index, int[] nums) {
        int tmp = nums[i];
        nums[i]=nums[index];
        nums[index]=tmp;
    }
    /**
     * 使用双指针，p0代表前面的指针，p2代表后面的指针，p0=0，p2=nums.length-1
     * 遍历nums数组，判断是否等于0，等于0就同p0角标下的元素进行替换，p0++
     *              判断是否等于2，等于2就同p2角标下的元素进行替换，p2--。
     *          这个时候要判断遍历的元素替换后是否等于2，等于2的话，无限进行替换。
     *          等于0的话就走上面。
     * @param nums
     * @author linmeng
     * @date 2021年2月23日 10:23
     * @return void
     */
    public static void sortColors3(int[] nums) {
        int length = nums.length,p0=0,p2=length-1;
        for (int i = 0; i < length; i++) {
            while (i<=p2 && nums[i]==2){
                int tmp=nums[p2];
                nums[p2]=nums[i];
                nums[i]=tmp;
                p2--;
            }
            if (nums[i]==0){
                int tmp=nums[p0];
                nums[p0]=nums[i];
                nums[i]=tmp;
                p0++;
            }
        }
    }

    /**
     * 问题：将0,1,2 进行排序
     * 解决1：直接使用Arrays.sort 方法
     * 解决2：定义一个指针指向数组头部，遍历两次数组，
     *      第一次将等于0的元素同指针所在元素进行替换，
     *      第二次将等于1的元素同指针所在元素进行替换
     * 解决3：定义两个指针，一个指向数组头部，一个指向数组尾部
     *      遍历数组，若元素等于0，则同第一个指针进行替换，若元素等于2，则同第二个指针进行替换
     *      当元素等于0时，被替换的元素肯定不是0或2，因为被替换的角标已经被遍历过了。
     *      当元素等于2时，被替换的元素有可能等于0或2，这个时候遍历角标减一
     * @param nums 需排序数组
     * @author linmeng
     * @date 2021年5月7日 15:38
     * @return void
     */
    public static void sortColorsFx(int[] nums) {
        int length = nums.length,left=0,right=length-1;
        for (int i = 0; i <= right; i++) {
            if (nums[i]==0){
                swap(i,left++,nums);
                continue;
            }
            if (nums[i]==2){
                swap(i,right--,nums);
                if (nums[i]==2 || nums[i]==0){
                    i--;
                }
            }
        }
    }
}
