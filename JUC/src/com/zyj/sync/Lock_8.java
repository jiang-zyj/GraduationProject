package com.zyj.sync;

import java.util.concurrent.TimeUnit;

/**
 * @program: JUC
 * @ClassName Lock_8
 * @author: YaJun
 * @Date: 2021 - 07 - 13 - 21:52
 * @Package: com.zyj.sync
 * @Description: 演示8种锁的问题
 */

class Phone {

    public static synchronized void sendSMS() throws InterruptedException {
        // 停留4秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----sendSMS");
    }

    public synchronized void sendEmail() {
        System.out.println("-----sendEmail");
    }

    public void getHello() {
        System.out.println("-----getHello");
    }

}

/**
 * @Description 8种锁
 * Synchronized是否是同一把锁，锁的范围
 *
 * 1. 标准访问，先打印短信还是邮件
 * -----sendSMS
 * -----sendEmail
 *
 * 2. 停4秒在短信方法内，先打印短信还是邮件
 * -----sendSMS
 * -----sendEmail
 *
 * 3. 新增普通的hello方法，是先打短信还是hello
 * -----getHello
 * -----sendSMS
 *
 * 4. 现在有两部手机，是先打印短信还是邮件
 * -----sendEmail
 * -----sendSMS
 *
 * 5. 两个静态同步方法，1部手机，先打印短信还是邮件
 * -----sendSMS
 * -----sendEmail
 *
 * 6. 两个静态同步方法，2部手机，先打印短信还是邮件
 * -----sendSMS
 * -----sendEmail
 *
 * 7. 1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件
 * -----sendEmail
 * -----sendSMS
 *
 * 8. 1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件
 * -----sendEmail
 * -----sendSMS
 *
 *
 * 解析：
 * 第一二种情况：
 * 因为锁的是this对象，所以第二个线程只能等待第一个线程结束才能获取对象锁
 * 第三种情况：
 * 因为是一个普通方法，所以与锁无关，直接就执行了。
 * 第四种情况：
 * 有两个对象，因为锁的是同步方法，是this对象，但是这里是两个不同的对象，所以不管你第一个线程执行完没有，跟第二个对象无关。
 * 第五六种情况：
 * 因为锁的是静态同步方法，所以锁住的是整个类对象，也就是字节码对象，此时就与this对象无关了，
 * 所以一次只能允许一个线程去执行同步方法
 * 第七八种情况：
 * 因为一个是静态同步方法，锁的是类对象，一个是同步方法，锁的是this对象，这两把锁不是同一把锁。
 * 可以比喻为宿舍，宿舍大门锁住了，但是宿舍的门还是可以打开的
 */
public class Lock_8 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()-> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(100);

        new Thread(()-> {
//            phone.sendEmail();
//            phone.getHello();
            phone2.sendEmail();
        }, "BB").start();
    }

}
