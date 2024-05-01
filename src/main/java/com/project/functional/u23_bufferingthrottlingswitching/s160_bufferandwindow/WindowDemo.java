package com.project.functional.u23_bufferingthrottlingswitching.s160_bufferandwindow;

import io.reactivex.rxjava3.core.Observable;


public class WindowDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create an Observable that emits a sequence of integers
        Observable<Integer> source = Observable.range(1, 10);

        // Apply the window operator to create windows, each containing 3 items
        Observable<Observable<Integer>> windows = source.window(3);

        // Subscribe to the windows and print the items of each window
        windows.subscribe(window -> {
            System.out.println("New Window");
            window.subscribe(
                    item -> System.out.println("Item: " + item),
                    Throwable::printStackTrace,
                    () -> System.out.println("Window Complete")
            );
        });
    }

}
