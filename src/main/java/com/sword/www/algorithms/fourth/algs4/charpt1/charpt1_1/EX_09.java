package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;
/**
* @Description:    正整数转二进制字符串
* @Author:         linmeng
* @CreateDate:     2020/6/14 22:45
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/14 22:45
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EX_09 {

    public static void main(String[] args) {
        System.out.println(intTransferToBinary(-4));
    }
    /***
    * @description 整数转二进制
    * @author  linmeng
    * @date    2020/6/15 22:40
    */
    public static String intTransferToBinary(int num){
        StringBuilder res = new StringBuilder();
        while (num>0){
            res.append(num%2);
            num=num/2;
        }
        return res.reverse().toString();
    }
}
