package com.zyj.juc;

/**
 * @program: JUC
 * @ClassName CyclicBarrierDemo
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 20:22
 * @Package: com.zyj.juc
 * @Description: 演示 CyclicBarrier
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 集齐7颗龙珠就可以召唤神龙
 * @author 才二
 */
public class CyclicBarrierDemo {

    /**
     * 创建固定值
     */
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        // 创建 CyclicBarrier
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(NUMBER, ()-> {
                    System.out.println("集齐7颗龙珠就可以召唤神龙");
                });

        // 集齐7颗龙珠的过程
        for (int i = 1; i <= 6; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "颗龙珠收集到了");
                try {
                    // 等待
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
