package com.creditease.selenium.service;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class AssertService {

    private static Logger logger = Logger.getLogger(AssertService.class);

    public static boolean assertPage(WebDriver driver, List list) {

        logger.info("list = " + list.toString());
        boolean flag = true;
        try {
            if (list.size() == 0 || list == null) {
                    flag = false;
            } else {
                for (Object assertContent : list) {
                    if (driver.getPageSource().contains(assertContent.toString())) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.info("AssertService e = " + e);
        }
        return flag;
    }


}
