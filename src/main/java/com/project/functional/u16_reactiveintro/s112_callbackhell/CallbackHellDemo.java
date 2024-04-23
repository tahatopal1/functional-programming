package com.project.functional.u16_reactiveintro.s112_callbackhell;

public class CallbackHellDemo {
    public static void main(String[] args) {
        operation("Initial Data", (result) -> {
            System.out.println("Result: " + result);
            operation("Input 1", result1 -> {
                System.out.println("Result: " + result1);
                operation("Input 2", result2 -> {
                    System.out.println("Result: " + result2);
                    operation("Input 3", result3 ->
                            System.out.println("Result: " + result3)
                    );
                });
            });
        });
    }

    interface Callback {
        void onComplete(String result);
    }

    static void operation(String input, Callback callback) {
        // Simulate an asynchronous operation
        new Thread(() -> callback.onComplete(input)).start();
    }

}



