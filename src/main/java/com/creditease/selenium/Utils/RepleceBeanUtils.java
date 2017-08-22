package com.creditease.selenium.Utils;

import com.creditease.selenium.bean.DataBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RepleceBeanUtils {

    public static DataBean getDataBean(String line) {
        List list = new ArrayList();
        DataBean dataBean = new DataBean();
        List<Object> linkList = new LinkedList<Object>();
        dataBean.setXpath(line.split(",")[0]);
        dataBean.setFrame(line.split(",")[1]);
        dataBean.setType(line.split(",")[2]);
        dataBean.setValue(line.split(",")[3]);
        String lineSplit = line.split(",")[4];
        String splitLine = lineSplit.substring(1,lineSplit.length() -1);
        for (String i : splitLine.split("、")){
            list.add(i);
        }
        dataBean.setAssertList(list);
        return dataBean;
    }
}
