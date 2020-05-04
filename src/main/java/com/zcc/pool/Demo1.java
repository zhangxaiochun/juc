package com.zcc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) {
      //  ExecutorService executorService = Executors.newSingleThreadExecutor(); //单个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5); //固定个线程
       // ExecutorService executorService = Executors.newCachedThreadPool(); //可伸缩线程

        try {
            for (int i = 1; i <=10 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭线程池
            executorService.shutdown();
        }
    }
}
