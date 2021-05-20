package com.zyj.Utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName ComputerUtils
 * @Auther: YaJun
 * @Date: 2021 - 04 - 01 - 11:37
 * @Description: com.zyj.Utils
 * @version: 1.0
 */
public class ComputerUtils {

    public static String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
