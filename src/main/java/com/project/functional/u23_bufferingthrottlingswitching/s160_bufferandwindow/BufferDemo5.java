package com.project.functional.u23_bufferingthrottlingswitching.s160_bufferandwindow;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class BufferDemo5 {

    // In the following example, we buffer the items based on time intervals
    // ... with max length for collection.

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS, 2)
                .subscribe(System.out::println);
        Thread.sleep(8000);
    }
}
