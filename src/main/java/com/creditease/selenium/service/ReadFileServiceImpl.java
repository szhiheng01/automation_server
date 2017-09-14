package com.creditease.selenium.service;

import com.creditease.selenium.bean.DataBean;
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
     * @param filePath
     * @return
     * @throws Exception
     */
    public static List<String> getList(String filePath) throws Exception {
        List<String> list = new LinkedList<String>();
        File file = ReadResourceUtils.getResourceFile(filePath);
        if (!file.exists()) {
            logger.info(filePath + "文件夹/不存在！！");
            return null;
        } else {
            File[] files = file.listFiles();
            if (file.isDirectory()) {
                //如果是文件夹返回的是文件的全路径
                for (File fileList : files) {
                    list.add(fileList.toString());
                }
                logger.info("files = " + files);
            } else {
                list.add(filePath);
            }
            return list;
        }
    }

    //读取文件内容
    public static FileBean getContent(String filePath) throws Exception {
        BufferedReader bufferedReader = null;
        List<DataBean> list = new LinkedList<DataBean>();
        try {
            if (filePath.split("/").length > 2) {
                bufferedReader = new BufferedReader(new FileReader(filePath));
            } else {
                File file = ReadResourceUtils.getResourceFile(filePath);
                bufferedReader = new BufferedReader(new FileReader(file));
            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(",").length < 5) {
                    logger.info("case 传餐有误！！");
                    return null;
                } else {
                    list.add(RepleceBeanServiceImpl.getDataBean(line));
                }
            }
        } catch (Exception e) {
            logger.info(filePath + "读取文件失败！！");
        } finally {
            if (bufferedReader == null) {
                bufferedReader.close();
            }
        }
        FileBean fileBean = new FileBean();
        fileBean.setFilePath(filePath);
        fileBean.setFileName(filePath.split("/")[filePath.split("/").length - 1]);
        fileBean.setBeans(list);
        return fileBean;
    }

    //读取

    public static List<FileBean> getContents(List<String> list) throws Exception {
        List<FileBean> linkedList = new LinkedList<FileBean>();
        if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                try {
                    linkedList.add(ReadFileServiceImpl.getContent(list.get(i)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return linkedList;
    }

    public static List initBean(String filePath) throws Exception {
        List list = getList(filePath);
        List<FileBean> fileBeans = getContents(list);
        return fileBeans;
    }
}