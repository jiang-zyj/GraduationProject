package com.zyj.callable;

/**
 * @program: JUC
 * @ClassName Demo01
 * @author: YaJun
 * @Date: 2021 - 07 - 14 - 11:23
 * @Package: com.zyj.callable
 * @Description: 比较Runnable和Callable接口
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Runnable接口
 */

class MyThread1 implements Runnable {
    @Override
    public void run() {

    }
}

/**
 * 实现Callable接口
 */
class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        return 200;
    }
}


/**
 * @author 才二
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runnable 接口创建线程
        new Thread(new MyThread1(), "AA").start();

        // Callable 接口，报错
//        new Thread(new MyThread2(), "BB").start();

        // FutureTask
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());

        // lam 表达式
        FutureTask<Integer> futureTask2 = new FutureTask<>(()-> {
            System.out.println(Thread.currentThread().getName() + " come in callable");
            return 1024;
        });



        // 创建一个线程
        new Thread(futureTask2, "lucy").start();

        while (!futureTask2.isDone()) {
            System.out.println("wait...");
        }

        // 调用FutureTask的get方法
        System.out.println(futureTask2.get());

        // 汇总一次，第二次直接输出结果
        System.out.println(futureTask2.get());

        System.out.println(Thread.currentThread().getName() + " come over");


        // Future 原理    未来任务
        /**
         * 1. 老师上课，口渴了，想喝水，但是上课去买水不合适，
         *  因此单开一个线程，找班长帮我买水
         *  把水买回来了，需要的时候直接get就行了
         *
         * 2. 4个同学，分别做计算，第一个同学计算 1+2+...+5，第二个同学计算 10+11+...+50
         *  第三个同学计算61+61+61，第四个同学计算100+101
         *  从中看出第二个同学任务量比较大
         *  FutureTask单开启一个线程给第二个同学计算，先汇总第一、三、四个同学，
         *  等最后第二个同学计算完之后，再统一汇总
         *
         * 3. 考试，做会做的，最后看不会做的题目
         *
         * 汇总一次
         */

    }

}
