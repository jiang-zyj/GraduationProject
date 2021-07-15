package com.zyj.readWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: JUC
 * @ClassName Demo01
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 23:50
 * @Package: com.zyj.readWrite
 * @Description: 读写锁的降级
 */
public class Demo01 {

    public static void main(String[] args) {
        // 可重入读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();;
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

        // 锁降级
        // 可以将写锁降级为读锁
        // 以下代码块的返回值为:
        // hello World
        // --read

        // 1. 获取到写锁
        writeLock.lock();
        System.out.println("hello World");

        // 2. 获取读锁
        readLock.lock();
        System.out.println("--read");

        // 3. 释放写锁
        writeLock.unlock();

        // 4. 释放读锁
        readLock.unlock();



        // 只能从写锁降级为读锁,不能将读锁升级为写锁
        // 以下操作的返回值为:--read,说明了在读操作时,无法进行写操作
//        readLock.lock();
//        System.out.println("--read");
//
//        writeLock.lock();
//        System.out.println("hello World");
//
//        // 2. 获取读锁
//
//
//        // 3. 释放写锁
//        writeLock.unlock();
//
//        // 4. 释放读锁
//        readLock.unlock();


    }

}
