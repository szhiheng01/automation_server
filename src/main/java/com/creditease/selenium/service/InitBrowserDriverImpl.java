package com.creditease.selenium.service;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitBrowserDriverImpl {

    private static Logger logger = Logger.getLogger(InitBrowserDriverImpl.class);

    public static WebDriver initBrowser(String browserType) {
        WebDriver driver = null;
        if (browserType.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
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
