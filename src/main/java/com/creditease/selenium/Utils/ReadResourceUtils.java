package com.creditease.selenium.Utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.File;
import java.io.IOException;

public class ReadResourceUtils {

    private ClassLoader classLoader = getClass().getClassLoader();
    public static File getResourceFile(String path){
        File file = new File(ClassLoader.getSystemResource(path).getFile());
        return file;
    }
}
