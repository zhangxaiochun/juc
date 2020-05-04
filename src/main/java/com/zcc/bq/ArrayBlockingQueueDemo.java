package com.zcc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        //1.
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));

        //抛出异常
        //System.out.println(arrayBlockingQueue.add("c"));
        //查询队首
            System.out.println(arrayBlockingQueue.element());
        //2.
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        //抛出异常
        //System.out.println(arrayBlockingQueue.remove());
    }
    /**
     * 有返回值，没有异常
     */
    public static void test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d"));  //false
        //查询队首
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());  //null
    }

    /**
     * 等待，阻塞（一直阻塞）
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        //程序会一直阻塞，不会停止
        //arrayBlockingQueue.put("d");

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        //程序会一直阻塞，不会停止
        //System.out.println(arrayBlockingQueue.take());
    }
    /**
     * 等待，阻塞（一直阻塞）
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS));  //等待两秒退出

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));  //null
    }
}
