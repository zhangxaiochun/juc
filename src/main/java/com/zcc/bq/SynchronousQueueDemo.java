package com.zcc.bq;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> blockingDeque =  new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put1");
                blockingDeque.put("1");
                System.out.println(Thread.currentThread().getName()+"put2");
                blockingDeque.put("2");
                System.out.println(Thread.currentThread().getName()+"put3");
                blockingDeque.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"取出"+blockingDeque.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"取出"+blockingDeque.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"取出"+blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
