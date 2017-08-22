package com.creditease.selenium.service;

import com.creditease.selenium.bean.DataBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunService {
    private static Logger logger = Logger.getLogger(RunService.class);

    public static Map doRun(List<DataBean> beanList, WebDriver driver) {
        boolean b = true;
        Map<Object, String> map = new HashMap<>();
        for (DataBean bean : beanList) {
            if (beanList.size() == 0) {
                return null;
            } else {
                try {
                    WebElement element = driver.findElement(By.xpath(bean.getXpath()));
                    logger.info("find the xpath....");
                    if (bean.getType().equals("1")) {
                        element.click();
                        b = AssertService.assertPage(driver, bean.getAssertList());
                        if (b) {
                            map.put(bean, "运行成功");
                        } else {
                            map.put(bean, "运行失败");
                            break;
                        }
                    } else {
                        element.clear();
                        element.sendKeys(bean.getValue());
                    }

                } catch (Exception e) {
                    map.put(bean, e.getMessage());
                    break;
                }
            }
        }
        return map;
    }

        public static void doRuns(List<List<DataBean>> list,WebDriver driver){


            if (list.size() == 0 || list == null){
                return;
            }
            for (List listBean : list){
                Map map = doRun(listBean,driver);
                logger.info("resoultMap = " + map);
            }

        }

    }
