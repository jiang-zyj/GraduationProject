package com.zyj.Utils;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName QrcodeUtils
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 21:50
 * @Description: com.zyj.Utils
 * @version: 1.0
 */
public class QrcodeUtils {

    public static void getHealthCode(Map<String, Object> map, String uid, HttpServletRequest req, HttpServletResponse resp) {
        try {
            //生成一个二维码

            //定义一个json格式字符串对象
            //创建一个jsonobject对象
            JSONObject jsonObject = new JSONObject();
            //给jsonObject对象中存放数据
            for (String key : map.keySet()) {
                jsonObject.put(key, map.get(key));
            }
            //将json对象转换为一个json格式的字符串
            String s = jsonObject.toString();

            //创建一个矩阵对象
            //二维码的宽度
            int widht = 200;
            //二维码的高度
            int height = 200;

            //创建一个map集合
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            //第一个参数表示内容，第二个参数表示生成的类型  ，第三个宽度，第四个参数表示高度，
            BitMatrix bitMatrix = new MultiFormatWriter().encode(s, BarcodeFormat.QR_CODE, widht, height, hints);

            //生成的路径
            String filePath = "static/code/";
            String fileName = uid + System.currentTimeMillis() + ".jpg";

            // 将文件名存入 Session 作用域下
            req.getSession().setAttribute("code", fileName);
            //创建一个路径对象
            Path p = FileSystems.getDefault().getPath(filePath, fileName);

            //将矩阵对象生成为一个图片
            MatrixToImageWriter.writeToPath(bitMatrix, "jpg", p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
