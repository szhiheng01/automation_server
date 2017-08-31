package com.creditease.selenium.service;

import com.creditease.selenium.Utils.ReadResourceUtils;
import com.creditease.selenium.bean.FileBean;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */


public class ReadFileServiceImpl {

    private static Logger logger = Logger.getLogger(ReadFileServiceImpl.class);

    /**
     * 判断是文件夹还是文件
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static List<String> getList(FileBean bean) throws Exception {
        List<String> list = new LinkedList<String>();
        File file = ReadResourceUtils.getResourceFile(bean.getFilePath());
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            logger.info(bean.getFilePath() + "文件夹/不存在！！");
            return null;
        } else {
            File[] files = file.listFiles();
            if (file.isDirectory()) {
                //如果是文件夹返回的是文件的全路径
                for (File fileList : files) {
                    list.add(fileList.toString());
                }
                logger.info("files = " + files.toString());
            } else {
                //如果是文件则读取文件内容
                try {
                    logger.info("file = " + file);
                    bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        list.add(line);
                        logger.info("line = " + line);
                    }
                } catch (Exception e) {
                    logger.info("ReadFileServiceImpl.getList()" + "文件读取失败");
                } finally {
                    try{
                        if (bufferedReader == null){
                            bufferedReader.close();
                        }
                    bufferedReader.close();
                    }catch (Exception e){
                        logger.info("ReadFileServiceImpl = " + e);
                    }
                }
            }
        }
        return list;
    }

    //读取文件内容
    public static List<Object> getContent(String filePath) throws Exception {
        System.out.println(filePath);
        BufferedReader bufferedReader = null;
        List<Object> list = new LinkedList<Object>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(",").length < 6) {
                    logger.info("case 传餐有误！！");
                    return null;
                } else {
                    list.add(RepleceBeanServiceImpl.getDataBean(line));
                }
            }
        } catch (Exception e) {
            logger.info(filePath + "读取文件失败！！");
        } finally {
            if (bufferedReader == null){
                bufferedReader.close();
            }
        }
        return list;
    }

    //读取
    public static List getContents(List<String> list) throws Exception{
        List linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).split(",").length <= 6 && list.get(i).split(",").length > 2) {
                    linkedList.add(RepleceBeanServiceImpl.getDataBean(list.get(i)));
                } else {
                    try {
                        linkedList.add(ReadFileServiceImpl.getContent(list.get(i)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            logger.info(list + "list is null！！");
        }
        return linkedList;
    }

}
