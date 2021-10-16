package com.bh1ofp;

public class RunnableDemo implements Runnable {

    private String returnValue;

    @Override
    public void run() {
        System.out.println("线程执行......");
        /** 模拟IO*/
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕......");
        returnValue = "这是线程返回值";
    }
    public String getReturnValue(){
        return returnValue;
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo= new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
        while (runnableDemo.getReturnValue() == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(runnableDemo.getReturnValue());
    }
}
