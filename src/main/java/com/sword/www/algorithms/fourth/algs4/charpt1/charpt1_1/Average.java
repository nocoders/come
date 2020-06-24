package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

import com.sword.www.algorithms.fourth.algs4.util.StdOut;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
* @Description:    测试 main方法输入流获取数据
 *        输出数据写入文件  点击 run ->Edit configrations->logs->Save console output to file 这里面能传参数
 *        文件输入重定向，这个不知道怎么搞，最后还是文件数据流按行读取吧
* @Author:         linmeng
* @CreateDate:     2020/6/13 21:08
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/13 21:08
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Average {
    public static void main(String[] args) throws Exception {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile("classpath:data/InDouble.txt"))));
        double sum = 0;
        int count =0;
        String data;
        while ((data = inputStream.readLine())!=null){
            sum += Double.parseDouble(data);
            count++;
        }
        double avg = sum/count;
        StdOut.printf("Average is %.5f\n",avg);
    }
}
