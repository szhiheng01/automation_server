package com.creditease.selenium.bean;

import java.util.List;

public class DataBean {

    String Xpath;
    String frame;
    String type;
    String value;
    List assertList;

    public String getXpath() {
        return Xpath;
    }

    public void setXpath(String xpath) {
        Xpath = xpath;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List getAssertList() {
        return assertList;
    }

    public void setAssertList(List assertList) {
        this.assertList = assertList;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "Xpath='" + Xpath + '\'' +
                ", frame='" + frame + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", assertList=" + assertList +
                '}';
    }
}
