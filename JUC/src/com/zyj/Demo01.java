package com.zyj;

/**
 * @program: JUC
 * @ClassName Demo01
 * @author: YaJun
 * @Date: 2021 - 07 - 12 - 23:30
 * @Package: com.zyj
 * @Description:
 */
public class Demo01 {

    public static void main(String[] args) {
        Thread AAA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "AAA");

        // 设置守护线程
        AAA.setDaemon(true);

        AAA.start();

        System.out.println(Thread.currentThread().getName() + " over");
    }

}
