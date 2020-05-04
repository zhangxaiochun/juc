package com.zcc.lock01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinklockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==>myLock");
        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==>myUnLock");
            atomicReference.compareAndSet(thread,null);
    }
}
class test{
    public static void main(String[] args) throws InterruptedException {
        SpinklockDemo spinklockDemo = new SpinklockDemo();
        new Thread(()->{
            spinklockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinklockDemo.myUnLock();
            }
        },"T1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinklockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinklockDemo.myUnLock();
            }
        },"T2").start();
    }
}
