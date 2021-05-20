package com.zyj.Test;

import com.zyj.Utils.QrcodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HealthCodeTest
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 21:35
 * @Description: com.zyj.Test
 * @version: 1.0
 */
public class HealthCodeTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("testName", "小白");
        map.put("testUid", "123456789123456789");
        map.put("健康码状态", "低风险");
        String uid = "testUid";
//        QrcodeUtils.getHealthCode(map,uid);
    }

}
