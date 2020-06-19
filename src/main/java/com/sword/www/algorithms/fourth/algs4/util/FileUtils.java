package com.sword.www.algorithms.fourth.algs4.util;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @Description:    文件工具类
* @Author:         linmeng
* @CreateDate:     2020/6/14 22:19
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/14 22:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class FileUtils {

    public static Integer[] getArrayfromFile(String filePath) throws Exception {
        List<Integer> res = new ArrayList<>(1024);
        String data;
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile("classpath:"+filePath))));
        while ((data = inputStream.readLine())!=null){
            res.add(Integer.parseInt(data));
        }
        int[] result = new int[res.size()];
        return (Integer[])res.toArray();
    }

}
