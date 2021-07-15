package com.zyj.juc;

/**
 * @program: JUC
 * @ClassName CountDownLatchDemo
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 12:15
 * @Package: com.zyj.juc
 * @Description: 演示 CountDownLatch
 */

import java.util.concurrent.CountDownLatch;

/**
 * 例子：6个同学陆续离开教室之后，班长锁门
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        // 创建 CountDownLatch 对象，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "号同学离开了...");

                // 线程执行完之后，计数 -1
                countDownLatch.countDown();

            }, String.valueOf(i)).start();
        }

        // 等待
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "班长锁门离开了");
    }

}
