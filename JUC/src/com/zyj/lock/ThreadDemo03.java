package com.zyj.lock;

/**
 * @program: JUC
 * @ClassName ThreadDemo03
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 11:27
 * @Package: com.zyj.lock
 * @Description: 实现线程定制化通信
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一步  创建资源类
 */
class ShareResource {
    /**
     * 定义标志位    1 AA    2 BB    3 CC
     */
    private int flag = 1;

    // 创建Lock锁
    private Lock lock = new ReentrantLock();

    // 创建三个condition
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    /**
     * 打印 5 次，参数loop为第几轮
     */
    public void print5(int loop) {
        // 上锁
        lock.lock();
        try {
            // 判断
            while (flag != 1) {
                // 等待
                c1.await();
            }
            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " :: " + i + " 轮数::" + loop);
            }
            // 修改标志位
            flag = 2;
            // 通知 BB 线程
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印 10 次，参数loop为第几轮
     */
    public void print10(int loop) {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + " ::轮数：" + loop);
            }
            // 修改标志位
            flag = 3;
            // 通知 CC 线程
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印 15 次，参数loop为第几轮
     */
    public void print15(int loop) {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i < 16; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + " ::轮数：" + loop);
            }
            // 修改标志位
            flag = 1;
            // 通知 AA 线程
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class ThreadDemo03 {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()-> {
            for (int i = 1; i < 11; i++) {
                shareResource.print5(i);
            }
        }, "AA").start();

        new Thread(()-> {
            for (int i = 1; i < 11; i++) {
                shareResource.print10(i);
            }
        }, "BB").start();

        new Thread(()-> {
            for (int i = 1; i < 11; i++) {
                shareResource.print15(i);
            }
        }, "CC").start();
    }

}
