package com.creditease.selenium.service;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AssertService {

    private static Logger logger = Logger.getLogger(AssertService.class);

    public boolean assertPage(WebDriver driver, List list){

        boolean flag = true;
        try{
            if (list.size() == 0 || list != null) {

            }else {
                for (Object assertContent : list) {
                    if (driver.getPageSource().equals(assertContent)) {
                        flag = true;
                    }else {
                        flag = false;
                    }
                }
            }
        }catch (Exception e){
            logger.info(e);
        }
        return flag;
    }



}
