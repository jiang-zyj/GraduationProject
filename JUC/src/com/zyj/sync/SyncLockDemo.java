package com.zyj.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JUC
 * @ClassName SyncLockDemo
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 23:09
 * @Package: com.zyj.sync
 * @Description: synchronized和lock演示重入锁【递归锁】
 */
public class SyncLockDemo {

    public synchronized void add() {
        add();
    }

    public static void main(String[] args) {

        // Lock演示重入锁

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "外层");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "内层");
                } finally {
//                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();


        // 创建新线程
        new Thread(()-> {
            lock.lock();
            System.out.println("aaa");
            lock.unlock();
        }, "t2").start();

        // 递归调用，栈溢出异常 java.lang.StackOverflowError
//        new SyncLockDemo().add();

        // synchronized
//        Object o = new Object();
//
//        new Thread(()-> {
//            synchronized (o) {
//                System.out.println(Thread.currentThread().getName() + "外层");
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + "中层");
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName() + "内层");
//                    }
//                }
//            }
//        }, "AA").start();
    }

}
