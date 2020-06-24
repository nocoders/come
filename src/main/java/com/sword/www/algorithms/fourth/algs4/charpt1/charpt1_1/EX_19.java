package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

import java.util.HashMap;
import java.util.Map;

public class EX_19 {

    public static void main(String[] args) {
        long f = F2(10);
        System.out.println();
    }
    private static Map<Integer,Long> map = new HashMap<>(64);
    static {
        map.put(0,0L);
        map.put(1,1L);
    }
    /***
     * @description 保存已经计算过的斐波那契数列
     * @author  linmeng
     * @return
     * @exception
     * @date    2020/6/16 16:51
     */
    public static long F2(int N){
        if (map.get(N)!=null){
            return map.get(N);
        }
        if (map.get(N - 1)==null){
            map.put(N-1,F2(N-1));
        }
        if (map.get(N - 2)==null){
            map.put(N-2,F2(N-2));
        }
        return F2(N-1)+F(N-2);
    }

    /***
    * @description 重复计算斐波那契数列
    * @author  linmeng
    * @return
    * @exception
    * @date    2020/6/16 16:51
    */
    public static long F(int N){
        if (N<2){
            return N;
        }
        return F(N-1)+F(N-2);
    }
}
