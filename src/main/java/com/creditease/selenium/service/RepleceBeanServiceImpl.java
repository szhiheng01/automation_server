package com.creditease.selenium.service;

import com.creditease.selenium.bean.DataBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class RepleceBeanServiceImpl {

    public static DataBean getDataBean(String line) {
        List list = new ArrayList();
        DataBean dataBean = new DataBean();
        List<Object> linkList = new LinkedList<Object>();
        dataBean.setXpath(line.split(",")[0]);
        dataBean.setFrame(line.split(",")[1]);
        dataBean.setFrame_xpath(line.split(",")[2]);
        dataBean.setType(line.split(",")[3]);
        dataBean.setValue(line.split(",")[4]);
        String lineSplit = line.split(",")[5];

        String splitLine = lineSplit.substring(1,lineSplit.length() -1);
        for (String i : splitLine.split("、")){
            list.add(i);
        }
        dataBean.setAssertList(list);
        return dataBean;
    }
}
