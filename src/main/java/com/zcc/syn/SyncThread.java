package com.zcc.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步线程
 */
class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
class test{
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
        /*SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();*/
    }
}

