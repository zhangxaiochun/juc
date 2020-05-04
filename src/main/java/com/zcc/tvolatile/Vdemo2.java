package com.zcc.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Vdemo2 {
    //volatile不保证原子性
    public volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();  //加一方法
    }
    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
