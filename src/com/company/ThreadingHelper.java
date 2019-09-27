package com.company;

public class ThreadingHelper extends Thread{

    String message;

    public ThreadingHelper(String msg){
        message = msg;
    }

    Threading t = new Threading("");
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+ "message="+message);
        try {
            Thread.sleep(20000);
        }catch(InterruptedException e){
            System.out.println("caught"+e);
        }
    }
}
