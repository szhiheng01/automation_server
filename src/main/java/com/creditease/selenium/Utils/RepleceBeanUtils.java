package com.creditease.selenium.Utils;

import com.creditease.selenium.bean.DataBean;

import java.util.LinkedList;
import java.util.List;

public class RepleceBeanUtils {

    public static DataBean getDataBean(String line) {
        DataBean dataBean = new DataBean();
        List<Object> linkList = new LinkedList<Object>();
        dataBean.setXpath(line.split(",")[0]);
        dataBean.setType(line.split(",")[1]);
        dataBean.setFrame(line.split(",")[2]);
        dataBean.setValue(line.split(",")[3]);
        dataBean.setAssertList(line.split(",")[4]);
        return dataBean;
    }
}
