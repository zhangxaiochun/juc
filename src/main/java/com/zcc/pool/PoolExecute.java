package com.zcc.pool;

import java.util.concurrent.*;

/**
 * new ThreadPoolExecutor.AbortPolicy() ：抛出异常
 *  new ThreadPoolExecutor.CallerRunsPolicy() : 由创建他的线程执行main
 *  new ThreadPoolExecutor.DiscardPolicy()：队列满了，丢掉任务，不抛出异常
 *  new ThreadPoolExecutor.DiscardOldestPolicy():队列满了，尝试去和最早的队列竞争，竞争失败，则被丢掉。，不抛出异常
 */
public class PoolExecute {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
          2,
                5,
                3,
                TimeUnit.SECONDS,
          new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
          new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            //最大承载：Deque+Max 此处：5+3
            for (int i = 1; i <=10 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName());
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
