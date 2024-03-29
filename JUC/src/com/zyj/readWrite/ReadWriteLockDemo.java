package com.zyj.readWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * @program: JUC
 * @ClassName ReadWriteLockDemo
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 22:36
 * @Package: com.zyj.readWrite
 * @Description: 演示读写锁
 */


import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 */
class MyCache {

    /**
     * 创建map集合
     */
    private volatile Map<String,Object> map = new HashMap<>();

    /**
     * 创建读写锁对象
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 放数据
    public void putData(String key, Object value) {

        // 添加写锁
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " 正在做写操作 " + key);
            // 暂停一会
            TimeUnit.MICROSECONDS.sleep(300);
            // 放数据
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写完了 " + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放写锁
            readWriteLock.writeLock().unlock();
        }
    }

    // 取数据
    public Object getData(String key) {

        // 添加读锁
        readWriteLock.readLock().lock();

        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + " 正在取数据 " + key);
            // 暂停一会
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 取完了 " + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放读锁
            readWriteLock.readLock().unlock();
        }
        return result;
    }
}


public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {

        MyCache myCache = new MyCache();

        // 创建线程放数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()-> {
                myCache.putData(num+"", num+"");
            }, String.valueOf(i)).start();
        }

        TimeUnit.MICROSECONDS.sleep(300);

        // 创建线程取数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()-> {
                myCache.getData(num+"");
            }, String.valueOf(i)).start();
        }

    }

}
