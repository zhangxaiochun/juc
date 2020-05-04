package com.zcc.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{ for (int i=0; i<10 ; i++) ticket.sale(); },"A").start();
        new Thread(()->{ for (int i=0; i<10 ; i++) ticket.sale(); },"B").start();
        new Thread(()->{ for (int i=0; i<10 ; i++) ticket.sale(); },"C").start();
    }
}
/**
 * lock三部曲：
 * 1. 创建锁
 * 2. 加锁
 * 3. 解锁
 */


class Ticket02{
    private int number=30;
    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票剩余:"+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
