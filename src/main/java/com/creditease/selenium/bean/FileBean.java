package com.creditease.selenium.bean;

import java.util.List;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class  FileBean {

    String fileName;
    String filePath;
    List<DataBean> beans;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<DataBean> getBeans() {
        return beans;
    }

    public void setBeans(List<DataBean> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", beans=" + beans +
                '}';
    }
}
