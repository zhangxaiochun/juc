package com.zcc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到停车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放车位
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
