package com.zcc.add;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int a=0;
        //倒计时,总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();  //等待计数器归零，然后再向下执行。
        countDownLatch.countDown();  //-1
        System.out.println("关闭");
    }
}
