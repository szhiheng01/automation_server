package com.creditease.selenium.service;

import com.creditease.selenium.bean.DataBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class InitBrowserDriverImpl {

    private static Logger logger = Logger.getLogger(InitBrowserDriverImpl.class);

    /**
     * 初始化浏览器
     * @param browserType IE浏览器、chrome浏览器、火狐浏览器
     * @return
     */
    public static WebDriver initBrowser(String browserType,String url) {
        WebDriver driver = null;
        if (browserType.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
            driver.get(url);
        } else if (browserType.equals("fireFox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equals("IE")) {
            driver = new InternetExplorerDriver();
        } else {
            logger.info("请输入浏览器名称！！");
        }
        return driver;
    }

}
