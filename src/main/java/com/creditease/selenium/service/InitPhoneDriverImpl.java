package com.creditease.selenium.service;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/9/1 上午11:42
 */

public class InitPhoneDriverImpl {

    private static Logger logger = Logger.getLogger(InitPhoneDriverImpl.class);

    public static void initPhoneriver() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/web/hub"),capabilities);

    }

}
