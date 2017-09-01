package com.creditease.selenium.Utils;

import com.creditease.selenium.service.ReadResourceUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: 读文件工具类
 * @date 2017/9/1 下午12:42
 */

public class ReadFileUtils {
    private static Logger logger = Logger.getLogger(ReadFileUtils.class);

    public static Map<String, String> readFile(String propertiesPath) {
        Map<String, String> map = new HashMap<>();
        Properties properties = new Properties();
        try {
            File file = ReadResourceUtils.getResourceFile(propertiesPath);
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            properties.load(inputStream);
            Iterator<String> iterator = properties.stringPropertyNames().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = properties.getProperty(key);
                map.put(key, value);
            }
            inputStream.close();

        } catch (Exception e) {
            logger.info("ReadFileUtils.readFile() = " + e);
            return null;
        }
        return map;
    }
}
