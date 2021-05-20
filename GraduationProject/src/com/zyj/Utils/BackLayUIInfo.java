package com.zyj.Utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BackLayUIInfo
 * @Auther: YaJun
 * @Date: 2021 - 04 - 20 - 12:00
 * @Description: com.zyj.Utils
 * @version: 1.0
 */
public class BackLayUIInfo {
    static JSONObject jsonObject = new JSONObject();

    public static void getAddInfo(HttpServletResponse response, boolean flag) {
        try {
            if (flag) {
                jsonObject.put("success", true);
                jsonObject.put("message", "ADD SUCCESS");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "ADD FAIL");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getDeleteInfo(HttpServletResponse response, boolean flag) {
        try {
            if (flag) {
                jsonObject.put("success", true);
                jsonObject.put("message", "Delete Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "Delete Fail");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getEditInfo(HttpServletResponse response, boolean flag) {
        try {
            if (flag) {
                jsonObject.put("success", true);
                jsonObject.put("message", "Edit Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "Edit Fail");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getBatchDeleteInfo(HttpServletResponse response, boolean flag) {
        try {
            if (flag) {
                jsonObject.put("success", true);
                jsonObject.put("message", "BatchDelete Success");
            } else {
                jsonObject.put("success", false);
                jsonObject.put("message", "BatchDelete Fail");
            }
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
