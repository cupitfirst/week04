package com.bh1ofp;

public class ThreadDemo  {

    public static void main(String[] args){
        RunnableDemo runnableDemo= new RunnableDemo();
        Thread threadDemo = new Thread(runnableDemo);
        threadDemo.start();
        try {
            threadDemo.join(); //使用join方法可以让子线程执行完毕后再执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(runnableDemo.getReturnValue());
        System.out.println("这是主线程");


    }

}
