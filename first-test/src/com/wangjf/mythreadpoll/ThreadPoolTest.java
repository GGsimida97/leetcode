package com.wangjf.mythreadpoll;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                r -> {
                    SecurityManager s = System.getSecurityManager();
                    ThreadGroup group = (s != null) ? s.getThreadGroup() :
                            Thread.currentThread().getThreadGroup();
                    String namePrefix = "pool-" +
                            poolNumber.getAndIncrement() +
                            "-thread-";
                    Thread t = new Thread(group, r,
                            namePrefix + threadNumber.getAndIncrement(),
                            0);
                    if (t.isDaemon())
                        t.setDaemon(false);
                    if (t.getPriority() != Thread.NORM_PRIORITY)
                        t.setPriority(Thread.NORM_PRIORITY);
                    return t;
                }, (e, r) -> {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        });

        ExecutorService pool = Executors.newFixedThreadPool(2);
//        Future<String> future = pool.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("aaaaa");
//                Thread.sleep(1000);
//                return "ok";
//            }
//        });
//        System.out.println(future.get());

        pool.execute(()->{
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "work1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        pool.execute(()->{
            System.out.println(Thread.currentThread().getName() + "work2");
        });
        pool.execute(()->{
            System.out.println(Thread.currentThread().getName() + "work3");
        });
//        pool.shutdown();
        pool.shutdownNow();
    }

}