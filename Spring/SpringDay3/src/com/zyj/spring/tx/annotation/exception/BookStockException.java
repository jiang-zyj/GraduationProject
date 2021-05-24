package com.zyj.spring.tx.annotation.exception;

/**
 * @ClassName BookStockException
 * @Auther: YaJun
 * @Date: 2021 - 03 - 21 - 22:53
 * @Description: com.zyj.spring.tx.annotation.exception
 * @version: 1.0
 */
public class BookStockException extends RuntimeException {

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
