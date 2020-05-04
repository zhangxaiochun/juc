package com.zcc.lock01;

import java.util.concurrent.TimeUnit;

public class Demolock {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.sms();
        },"B").start();
    }

}
class Phone{

    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}
