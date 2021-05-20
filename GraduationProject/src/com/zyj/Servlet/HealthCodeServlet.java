package com.zyj.Servlet;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.zyj.Pojo.Health_Code;
import com.zyj.Pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ${NAME}
 * @Auther: YaJun
 * @Date: 2021 - 04 - 09 - 18:06
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet("/healthCode")
public class HealthCodeServlet extends HttpServlet {

    private String uid;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            //生成一个二维码

            //定义一个json格式字符串对象
            //创建一个jsonobject对象
            JSONObject jsonObject = new JSONObject();
            //给jsonObject对象中存放数据
            // 获取 Session 作用域中的 用户对象与健康码对象
            User user = (User) request.getSession().getAttribute("user");
            Health_Code code = (Health_Code) request.getSession().getAttribute("code");
            // 存放数据
            jsonObject.put("name", user.getName());
            uid = user.getUid();
            jsonObject.put("uid", uid);
            jsonObject.put("code_Status", code.getCode_status());
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

            String path = request.getServletContext().getRealPath("/code");
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            //生成的路径
//            String filePath = "E:\\IDEA-workspace\\GraduationProject\\web\\img";
            String filePath = path;
            String fileName = uid + System.currentTimeMillis() + ".jpg";


            //创建一个路径对象
            Path p = FileSystems.getDefault().getPath(filePath, fileName);

            //将矩阵对象生成为一个图片
            MatrixToImageWriter.writeToPath(bitMatrix, "jpg", p);
            // 将文件名存入 Session 作用域下
//            Thread.sleep(10000);
            request.getSession().setAttribute("fileName", "\\" + fileName);
            request.getSession().setAttribute("filePath", filePath);
            request.getRequestDispatcher("pages/personal/client/viewCode.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
