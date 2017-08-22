package com.creditease.selenium.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileUtils {


    public static void writeFile(String path) throws Exception{
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedWriter == null) {
                bufferedWriter.close();
            }else {

            }
        }
    }




}
