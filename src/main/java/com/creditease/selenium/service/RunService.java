package com.creditease.selenium.service;

import com.creditease.selenium.bean.DataBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RunService {
    private static Logger logger = Logger.getLogger(RunService.class);

    public static void doRun(List<DataBean> beanList, WebDriver driver) {
        for (DataBean bean : beanList) {
            if (beanList.size() == 0) {
                return;
            } else {
                try {
                    WebElement element = driver.findElement(By.xpath(bean.getXpath()));
                    logger.info("find the xpath....");
                    if (bean.getType().equals("1")) {
                        element.click();
                    } else {
                        element.clear();
                        element.sendKeys(bean.getValue());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
