package com.sword.www.algorithms.concurrency.charpt2.find;

import java.io.File;

/**
 * TODO
 *
 * @author linmeng
 * @version 1.0
 * @date 27/9/2020 下午4:01
 */
public class SerialFileSearch {

    public static void searchFiles(File file, String fileName, Result result){
        File[] contents = file.listFiles();
        assert contents != null;
        for (File content : contents) {
            if (content.isDirectory()){
                searchFiles(content,fileName,result);
            }else {
                if (fileName.equals(content.getName())){
                    result.setFound(true);
                    result.setPath(content.getAbsolutePath());
                    System.out.printf("Serial Search: Path: %s%n",
                            result.getPath());
                    return;
                }
            }
            if (result.isFound()){
                return;
            }
        }
    }
}
