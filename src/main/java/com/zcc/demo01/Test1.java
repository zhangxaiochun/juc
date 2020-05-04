package com.zcc.demo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample exam = new WaitNotifyExample();
        executorService.execute(() -> exam.after());
        executorService.execute(() -> exam.before());
    }
}
class WaitNotifyExample{
    private Lock lock = new ReentrantLock();

    public synchronized void before() {
        System.out.println("before func");
        notifyAll();
        // 唤醒所有线程
    }

    public synchronized void after(){
        try {
            wait();
            // 执行wait() 操作将线程挂起，该线程会释放锁。 否则其他线程无法进入对象的同步方法或者同步控制块中，
            // 就无法执行notify()或notifyAll() 就会造成 死锁
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after func");
    }
}