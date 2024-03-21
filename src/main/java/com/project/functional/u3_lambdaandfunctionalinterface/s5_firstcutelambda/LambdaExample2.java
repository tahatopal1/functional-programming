package com.project.functional.u3_lambdaandfunctionalinterface.s5_firstcutelambda;

// Creating a class that inherits from the Runnable interface is too much work
// We can make it concise by using "Anonymous objects"
public class LambdaExample2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread executed!");
            }
        });
        thread.start();
    }

}
