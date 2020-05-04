package com.zcc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class CasDemo {
    public static void main(String[] args) {
       // AtomicInteger atomicInteger = new AtomicInteger(2020);
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference(2020,1);

       new Thread(()->{
           int temp = atomicInteger.getStamp();     //获得版本号
           System.out.println("a1->"+temp);

           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           //参数四：版本号加1
           atomicInteger.compareAndSet(2020,2022,atomicInteger.getStamp(),atomicInteger.getStamp()+1);
           System.out.println("a2->"+atomicInteger.getStamp());

           atomicInteger.compareAndSet(2020,2022,atomicInteger.getStamp(),atomicInteger.getStamp()+1);
           System.out.println("a3->"+atomicInteger.getStamp());

       },"a").start();

        new Thread(()->{
            int temp = atomicInteger.getStamp();
            System.out.println("b->"+temp);
        },"b").start();

    }
}
