package com.zyj.sync;

/**
 * @program: JUC
 * @ClassName ThreadDemo01
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 10:21
 * @Package: com.zyj.sync
 * @Description: Synchronized解决wait虚假唤醒
 */

/**
 * 第一步：创建资源类，定义属性和操作方法
 */
class Share {
    // 初始值
    private int number = 0;
    // +1 的方法
    public synchronized void incr() throws InterruptedException {
        // 第二步 判断   干活  通知
        // 判断number值是否为0,如果不是0,则等待
        while (number != 0) {
            this.wait();
        }
        // 如果number值是0,就+1操作
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        // 通知其他线程
        this.notifyAll();
    }

    // -1 的方法
    public synchronized void decr() throws InterruptedException {
        // 判断
        while (number != 1) {
            this.wait();
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        // 通知
        this.notifyAll();
    }
}

public class ThreadDemo01 {

    /**
     * 第三步:创建多个线程,调用资源类中的方法
     */
    public static void main(String[] args) {
        Share share = new Share();

        // 创建线程
        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();

    }

}
