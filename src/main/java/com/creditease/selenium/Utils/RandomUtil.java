package com.creditease.selenium.Utils;

import org.junit.Test;

import java.util.Random;

public class RandomUtil {

    public static int getRandom(){
        Random random = new Random();
        return random.nextInt(100000);
    }

}
