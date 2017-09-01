package com.creditease.selenium.controller;

import com.creditease.selenium.Utils.ReadFileUtils;
import com.creditease.selenium.bean.FileBean;
import com.creditease.selenium.service.InitBrowserDriverImpl;
import com.creditease.selenium.service.ReadFileServiceImpl;
import com.creditease.selenium.service.RunServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class RunTestCase {

    private static final String PROPERTIES_PATH = "init.properties";

    public static void main(String[] args) throws Exception {
        Map<String, String> map = ReadFileUtils.readFile(PROPERTIES_PATH);
        WebDriver driver = InitBrowserDriverImpl.initBrowser("chrome", map.get("url"));
        List list = ReadFileServiceImpl.initBean(map.get("filePath"));
        RunServiceImpl.doRuns(list, driver);
        Thread.sleep(2000);
        driver.quit();

    }


}
