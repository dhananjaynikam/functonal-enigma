package com.company;

public class Threading extends Thread{
    public static String msg = null;

    public void run(){
        System.out.println("Mesaage = " + msg);
    }

    public Threading(){
        this.msg = "blah";
    }

    public Threading(String message){
        this.msg = message;
    }

    public static void main(String[] args){

        Thread t1 = new Thread(new Threading());
        t1.start();
        try{t1.join();}catch(InterruptedException e){}

        Thread t3 = new Thread(new Threading("This call is from the Thread"));
        t3.start();
        try{t3.join();}catch(InterruptedException e){}

        Thread t4 = new Thread(){
            @Override
            public void run() {
               // super.run();
                System.out.println("This is from the t4");
                for(int i = 10; i > 0; i--){
                    System.out.print(i);
                }
                System.out.println("");
            }
        };

        Thread t5 = new Thread(){
            @Override
            public void run() {
                System.out.println("lets do this form the t5");
                for(int i = 1; i <= 10 ; i++){
                    System.out.print(i);
                }
                System.out.println("");
            }
        };
        t4.start();
        try{t4.join();}catch(InterruptedException e){}
        t5.start();
    }
}