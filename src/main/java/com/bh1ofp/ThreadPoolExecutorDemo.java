package com.bh1ofp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new CallableDemo());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("这是主线程");
        executorService.shutdown();
    }
}
