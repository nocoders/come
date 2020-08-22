package com.sword.www.util;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 使用依赖
 * <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
 *         <dependency>
 *             <groupId>org.apache.poi</groupId>
 *             <artifactId>poi</artifactId>
 *             <version>4.1.2</version>
 *         </dependency>
 *         <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
 *         <dependency>
 *             <groupId>org.apache.poi</groupId>
 *             <artifactId>poi-ooxml</artifactId>
 *             <version>4.1.2</version>
 *         </dependency>
 *
 *
 *         <!--Hutool Java工具包-->
 *         <dependency>
 *             <groupId>cn.hutool</groupId>
 *             <artifactId>hutool-all</artifactId>
 *             <version>4.5.7</version>
 *         </dependency>
 *
 * 根据某个字段，对一个excel表格进行sheet拆分
 * @author linmeng
 * @version 1.0
 * @date 21/8/2020 下午3:56
 */
public class ExportUtil {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("d:/1.xlsx");
        List<ExcelParam> list = reader.readAll(ExcelParam.class);
        ExcelWriter writer = new ExcelWriter("d:/2.xlsx","总记录");
        writer.addHeaderAlias("telephone", "手机号");
        writer.addHeaderAlias("province", "归属省份");
        writer.addHeaderAlias("date", "访问时间");
        writer.addHeaderAlias("code", "渠道码");
        writer.write(list);
        Map<String, List<ExcelParam>> maps = list.stream().collect(Collectors.groupingBy(ExcelParam::getCode));
        for (Map.Entry<String, List<ExcelParam>> entry : maps.entrySet()) {
            writer.setSheet(entry.getKey());
            writer.write(entry.getValue());
        }
        writer.close();

        System.out.println();
    }


}
