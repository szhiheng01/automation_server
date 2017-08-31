package com.creditease.selenium.service;

import com.creditease.selenium.Utils.TimesUtils;
import com.creditease.selenium.bean.DataBean;
import com.creditease.selenium.bean.FileBean;
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

    public static Map doRun(FileBean fileBean, WebDriver driver) {
        boolean flag = true;
        boolean b = true;
        Map<Object, String> map = new HashMap<>();
        if (fileBean.getBeans().size() == 0) {
            return null;
        } else {
            for (DataBean bean : fileBean.getBeans()) {
                try {
                    if (bean.getFrame().equals("1")) {
                        driver.switchTo().frame(driver.findElement(By.xpath(bean.getFrame_xpath())));
                        WebElement element = TimesUtils.getElement(driver, bean.getXpath(), WAIT_TIME);
                        logger.info("find the xpath.... = " + element);
                        if (bean.getType().equals("1")) {
                            element.click();
                            flag = AssertService.assertPage(driver, bean.getAssertList());
                            if (flag) {
                                b = true;
                            } else {
                                b = false;
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
                        logger.info("find the xpath.... = " + element);
                        if (bean.getType().equals("1")) {
                            element.click();
                            logger.info("sendKeys of the xpath = " + bean.getValue());
                            flag = AssertService.assertPage(driver, bean.getAssertList());
                            if (flag) {
                                b = true;
                            } else {
                                b = false;
                                break;
                            }
                        } else {
                            element.clear();
                            element.sendKeys(bean.getValue());
                            logger.info("sendKeys of the xpath = " + bean.getValue());
                        }
                    }

                } catch (Exception e) {
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            map.put(fileBean.getFileName(), "运行成功");
        } else {
            map.put(fileBean.getFileName(), "运行失败");
        }
        return map;
    }

    public static void doRuns(List<FileBean> list, WebDriver driver) throws Exception {

        if (list.size() == 0 || list == null) {
            return;
        }
        for (FileBean fileBean  : list) {
            Map map = doRun(fileBean, driver);
            for (Object key : map.keySet()) {
                String value = key + "," + (String) map.get(key);
                WriteFileServiceImpl.writeFile(value);
            }
            logger.info("resoultMap = " + map);
        }

    }

}