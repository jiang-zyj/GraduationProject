package com.zyj.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 16:46
 * @Description: com.zyj.Test
 * @version: 1.0
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        System.out.println(format);
    }
}
