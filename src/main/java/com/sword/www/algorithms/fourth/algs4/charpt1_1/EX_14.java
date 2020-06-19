package com.sword.www.algorithms.fourth.algs4.charpt1_1;
/**
* @Description:    求log2N
* @Author:         linmeng
* @CreateDate:     2020/6/16 10:21
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/16 10:21
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EX_14 {
    public static void main(String[] args) {
        System.out.println(lg(16));
    }
    public static int lg(int N){
        int res = 0;
        for (int i = N; i > 0;) {
            if (1<<i>N){
                if (res>0){
                    return res;
                }
                i=i/2;
            }else {
                res = i++;
            }
        }
        return 0;
    }
}
