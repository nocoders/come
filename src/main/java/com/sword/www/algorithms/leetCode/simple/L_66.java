package com.sword.www.algorithms.leetCode.simple;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author linmeng
 * @version 1.0
 * @date 2020/8/5 10:52
 */
public class L_66 {

    public static void main(String[] args) {
        int [] a = {9};
        int[] ints = plusOne(a);
        System.out.println();
    }
    /**
     * 需要注意的是最高位是否有进位，有进位的话当前的数组长度就不够用了，数组长度 需要加一，
     * 这个的判断有两种，一种是最开始直接声明一个比加一数组长度大一的数组，另一种是最后加完再判断是否需要copy，
     * 我觉得最开始声明好一点，代码简单，原来的数组就不动了
     * @author linmeng
     * @date 2020/8/5 10:53
     * @return int[]
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }

        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
//        if (digits == null || digits.length == 0 || (digits.length>1 && digits[0] == 0)){
//            return new int[0];
//        }
//        int len = digits.length,isCarry = 0;
//        digits[len-1] += 1;
//        int[] res = new int[len + 1];
//        for (int i = len -1; i >= 0; i--) {
//            int tmp =  digits[i] + isCarry;
//            isCarry = tmp / 10;
//            res[i+1] = tmp % 10;
//        }
//        res[0] = isCarry;
//        if (res[0] > 0){
//            return res;
//        }
//        return Arrays.copyOfRange(res,1,len+1);
    }
}
