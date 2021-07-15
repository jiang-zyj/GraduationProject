package com.zyj.lock;

/**
 * @program: JUC
 * @ClassName ThreadDemo02
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 11:03
 * @Package: com.zyj.lock
 * @Description: Lock解决wait虚假唤醒
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一步  创建资源类,定义属性和操作方法
 */
class Share {

    private int number = 0;

    // 创建Lock

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    // +1
    public void incr() {
        // 上锁
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }


    // -1
    public void decr() {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ThreadDemo02 {

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        }, "AA").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.incr();
            }
        }, "CC").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                share.decr();
            }
        },"DD").start();
    }

}
