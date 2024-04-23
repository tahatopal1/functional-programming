package com.project.functional.u16_reactiveintro.s112_callbackhell;

import lombok.SneakyThrows;

public class AsyncDemo {
    public static void main(String[] args) {
        Thread asyncTask = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                printNumbers();
            }
        });


        System.out.println("Main thread is running independently..."); // Prints as first
        asyncTask.start(); // Prints as third
        System.out.println("Asynchronous task has been completed!"); // Prints as second

        System.out.println("--------------------");


    }

    public static void printNumbers() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Number: " + i);
        }
    }

}
