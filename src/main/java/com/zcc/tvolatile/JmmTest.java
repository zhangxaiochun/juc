package com.zcc.tvolatile;

import java.util.concurrent.TimeUnit;

public class JmmTest {
    //控制台一直没有结束运行，因为 线程A 未停止
    public static volatile int num=0;
    public static void main(String[] args) throws InterruptedException {

        //创建一个线程，当num等于零的循环，不为零结束循环
        new Thread(()->{
            while (num==0){
                //System.out.println("输出num不为0");
            }
        },"线程A").start();

        TimeUnit.SECONDS.sleep(2);

        num=1;
        System.out.println(num);
    }
}
