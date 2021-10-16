package com.bh1ofp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程执行......");
        Thread.sleep(5000);
        System.out.println("线程执行完毕......");
        return "这是线程返回值";
    }

    public static void main(String[] args){
        FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());
        Thread thread = new Thread(futureTask);
        thread.start();
        String value = null;
        try {
            value = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(value);
        System.out.println("这是主线程");
    }
}
