package com.creditease.selenium.Utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;

public class ReadExcel {

    private static JSONObject resultJson = new JSONObject();
    private static final Logger logger = Logger.getLogger(ReadExcel.class);

    public static JSONArray readExcel(String fileName, int sheet, String key) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        JSONArray jsonArray = new JSONArray();
        try {
            InputStream inputStream = classloader.getResourceAsStream(fileName);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet readSheet = workbook.getSheet(sheet);
            int countRow = readSheet.getRows();
            int countLie = readSheet.getColumns();
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonObjects = new JSONObject();
            for (int j = 1; j < countLie; j++) {
                for (int k = 0; k < countRow; k++) {
                    Cell cell = readSheet.getCell(0, k);
                    Cell cellValue = readSheet.getCell(j, k);
                    if (!cell.getContents().equals(key)) {
                        if (cellValue.getContents() == null || cellValue.getContents().length() == 0) {
                            jsonObject.put(cell.getContents(), "");
                        } else {
                            jsonObject.put(cell.getContents(), cellValue.getContents());
                        }
                    } else {
                        jsonObject.put(cell.getContents(), jsonObjects);
                    }

                }
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        } catch (Exception e) {
            logger.info("读取文件失败。。。。。。。。");
            return null;
        }
    }
}
