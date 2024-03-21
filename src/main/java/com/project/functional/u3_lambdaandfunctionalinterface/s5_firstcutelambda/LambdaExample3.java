package com.project.functional.u3_lambdaandfunctionalinterface.s5_firstcutelambda;

// We can do it even more concise
// By using lambda expressions
// We don't need method name, access modifiers or return type 
public class LambdaExample3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread executed!"));
        thread.start();
    }
}
