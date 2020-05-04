package com.zcc.rwlock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁）：一次只能被一个线程占有
 * 共享锁（读锁）：多个线程占有
 * 读-读 可以共存
 * 读-写 不能共存
 * 写-写 不能共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        //MyCache myCache=  new MyCache();
        MyCacheLock myCache=  new MyCacheLock();

        //写入
        for (int i = 1; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存，不加锁会出现问题
 */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    //写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写完毕");
    }
    //读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取OK");
    }
}
/**
 * 自定义缓存加锁版
 */
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //存的时候，只希望同时只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            readWriteLock.writeLock().unlock();
        }
    }
    //读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}