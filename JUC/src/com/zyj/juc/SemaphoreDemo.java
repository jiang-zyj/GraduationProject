package com.zyj.juc;

/**
 * @program: JUC
 * @ClassName SemaphoreDemo
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 21:41
 * @Package: com.zyj.juc
 * @Description: 演示 Semaphore
 */

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 例子：6辆汽车，停3个车位
 * @author 才二
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 创建 Semaphore，设置许可量
        Semaphore semaphore = new Semaphore(3);

        // 模拟6辆汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(()-> {
                try {
                    // 抢占车位
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + "抢到了车位");

                    // 设置随机停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    System.out.println(Thread.currentThread().getName() + "-----离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

}
