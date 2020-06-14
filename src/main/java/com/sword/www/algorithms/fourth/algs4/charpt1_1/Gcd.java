package com.sword.www.algorithms.fourth.algs4.charpt1_1;
/**
* @Description:    递归求最大公约数
* @Author:         linmeng
* @CreateDate:     2020/6/14 18:29
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/14 18:29
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Gcd {

    public static void main(String[] args) {
        System.out.println(gcd(6,3));
    }

    /**
    * @description 使用递归求最大公因子，求余，余数为零直接返回，不为零再让除数跟余数作为参数继续执行该方法
    * @author  linmeng
    * @param   p 传入参数
    * @return  int 返回最大公因子
    * @exception null
    * @date    2020/6/14 18:49
    */
    public static int gcd(int p,int q){
        if (q==0){
            return p;
        }
        int r = p%q;
        return gcd(q,r);
    }
}
