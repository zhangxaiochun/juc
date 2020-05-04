package com.zcc.lock01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demolock02 {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();
        new Thread(()->{
            phone.sms();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.sms();
        },"B").start();
    }

}
class Phone2{
    //锁必须配对
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            call();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

