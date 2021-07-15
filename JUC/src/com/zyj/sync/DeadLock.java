package com.zyj.sync;

import java.util.concurrent.TimeUnit;

/**
 * @program: JUC
 * @ClassName DeadLock
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 11:03
 * @Package: com.zyj.sync
 * @Description: 演示死锁
 */
public class DeadLock {

    // 创建两个对象
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {

        new Thread(()-> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "持有锁a，试图获取锁b");
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "获取到锁b");
                }
            }
        },"A").start();

        new Thread(()-> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "持有锁b，试图获取锁a");
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "获取到锁a");
                }
            }
        },"A").start();


    }

}
