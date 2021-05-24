package com.zyj.spring.tx.xml.exception;

/**
 * @ClassName UserAccountException
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 23:01
 * @Description: com.zyj.spring.tx.annotation.exception
 * @version: 1.0
 */
public class UserAccountException extends RuntimeException {

    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
