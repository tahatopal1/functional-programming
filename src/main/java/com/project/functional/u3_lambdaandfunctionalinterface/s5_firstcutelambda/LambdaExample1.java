package com.project.functional.u3_lambdaandfunctionalinterface.s5_firstcutelambda;

public class LambdaExample1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
