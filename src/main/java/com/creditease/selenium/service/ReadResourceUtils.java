package com.creditease.selenium.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.File;
import java.io.IOException;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:03
 */

public class ReadResourceUtils {

    private ClassLoader classLoader = getClass().getClassLoader();

    public static File getResourceFile(String path) {
        File file = new File(ClassLoader.getSystemResource(path).getFile());
        return file;
    }
}
