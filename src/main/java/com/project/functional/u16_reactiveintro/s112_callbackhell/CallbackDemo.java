package com.project.functional.u16_reactiveintro.s112_callbackhell;

import lombok.SneakyThrows;

public class CallbackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running...");

        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                new CallbackDemo().runningAsync(new CustomCallback() {
                    @Override
                    public void call() {
                        System.out.println("Callback called!");
                    }
                });
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Main thread is completed!");

    }

    public void runningAsync(CustomCallback customCallback) throws InterruptedException {
        System.out.println("I am running in separate thread!");
        customCallback.call();
        Thread.sleep(5000);
    }

}
