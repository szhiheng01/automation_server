package com.creditease.selenium.controller;

import com.creditease.selenium.bean.FileBean;
import com.creditease.selenium.service.InitBrowserDriverImpl;
import com.creditease.selenium.service.ReadFileServiceImpl;
import com.creditease.selenium.service.RunServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class RunTestCase {

    private static final String FILE_PATH = "casefile/";
    public static void main(String[] args) throws Exception{

        WebDriver driver = InitBrowserDriverImpl.initBrowser("chrome");
        List list = ReadFileServiceImpl.initBean(FILE_PATH);
        RunServiceImpl.doRuns(list,driver);
        Thread.sleep(2000);
        driver.quit();

    }



}
