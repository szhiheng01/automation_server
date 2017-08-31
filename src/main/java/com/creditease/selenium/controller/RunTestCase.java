package com.creditease.selenium.controller;

import com.creditease.selenium.service.InitBrowserDriverImpl;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class RunTestCase {

    WebDriver driver;
    @Test
    public void testRunCase(){
        driver = InitBrowserDriverImpl.initBrowser("chrome");


    }

    @After
    public void quits() throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }

}
