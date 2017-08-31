package com.creditease.selenium.service;

import com.creditease.selenium.Utils.TimesUtils;
import com.creditease.selenium.bean.DataBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class RunServiceImpl {
    private static Logger logger = Logger.getLogger(RunServiceImpl.class);
    private static final int WAIT_TIME = 10;

    public static Map doRun(List<DataBean> beanList, WebDriver driver) {
        boolean flag = true;
        Map<Object, String> map = new HashMap<>();
        for (DataBean bean : beanList) {
            if (beanList.size() == 0) {
                return null;
            } else {
                try {
                    if (bean.getFrame().equals("1")) {
                        driver.switchTo().frame(driver.findElement(By.xpath(bean.getFrame_xpath())));
                        WebElement element = TimesUtils.getElement(driver, bean.getXpath(), WAIT_TIME);
                        logger.info("find the xpath...." + element);
                        if (bean.getType().equals("1")) {
                            element.click();
                            flag = AssertService.assertPage(driver, bean.getAssertList());
                            if (flag) {
                                map.put(bean, "运行成功");
                            } else {
                                map.put(bean, "运行失败");
                                break;
                            }
                        } else {
                            element.clear();
                            element.sendKeys(bean.getValue());
                            logger.info("sendKeys of the xpath " + bean.getValue());
                        }
                        driver.switchTo().defaultContent();
                    } else {
                        WebElement element = TimesUtils.getElement(driver, bean.getXpath(), WAIT_TIME);
                        logger.info("find the xpath...." + element);
                        if (bean.getType().equals("1")) {
                            element.click();
                            flag = AssertService.assertPage(driver, bean.getAssertList());
                            if (flag) {
                                map.put(bean, "运行成功");
                            } else {
                                map.put(bean, "运行失败");
                                break;
                            }
                        } else {
                            element.clear();
                            element.sendKeys(bean.getValue());
                            logger.info("sendKeys of the xpath" + bean.getValue());
                        }
                    }
                } catch (Exception e) {
                    map.put(bean, e.getMessage());
                    break;
                }
            }
        }
        return map;
    }

    public static void doRuns(List<List<DataBean>> list, WebDriver driver) {

        if (list.size() == 0 || list == null) {
            return;
        }
        for (List listBean : list) {
            Map map = doRun(listBean, driver);
            logger.info("resoultMap = " + map);
        }

    }

}