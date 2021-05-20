package com.zyj.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DataFormatTest
 * @Auther: YaJun
 * @Date: 2021 - 04 - 09 - 16:50
 * @Description: com.zyj.Utils
 * @version: 1.0
 */
public class DataFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = dateFormat.format(new Date());
        System.out.println(format);
        Date date = dateFormat.parse(format);
        System.out.println(date);
    }
}
