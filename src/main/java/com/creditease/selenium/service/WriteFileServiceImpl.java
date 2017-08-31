package com.creditease.selenium.service;

import com.creditease.selenium.Utils.TimesUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class WriteFileServiceImpl {

    private static Logger logger = Logger.getLogger(WriteFileServiceImpl.class);
    private static final String FILE_PATH = "logs/caseLogs/";
    private static final String SUFFIX = "_Run.log";
    String time = "";

    /**
     * 将测试结果返回到文件中
     *
     * @param line
     * @throws Exception
     */
    public static void writeFile(String line) throws Exception {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH + TimesUtils.getStringDate() + SUFFIX));
            if (line != null && line.length() > 0) {
                bufferedWriter.write(line + "\r\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            logger.info("WriteFileServiceImpl.writeFile() = " + "写入失败！！！");
            logger.info("WriteFileServiceImpl.writeFile() = " + e);
        } finally {
            try {
                if (bufferedWriter == null) {
                    bufferedWriter.close();
                } else {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                logger.info("WriteFileServiceImpl.writeFIle() = " + "关闭失败！！！");
            }
        }
    }

    @Test
    public void aaa() throws Exception {
//        for (int i = 0; i < 10; i++) {
        WriteFileServiceImpl.writeFile("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        WriteFileServiceImpl.writeFile("AAAAAAAAAAAAAAAAAAAAAAAAAAAb、");
//        }

    }

}
