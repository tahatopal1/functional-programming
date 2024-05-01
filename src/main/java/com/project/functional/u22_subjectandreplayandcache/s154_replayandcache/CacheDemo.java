package com.project.functional.u22_subjectandreplayandcache.s154_replayandcache;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class CacheDemo {
    public static void main(String[] args) throws InterruptedException {

        // Exactly the same with .range()
        // However, range method has some more flexibilities compared to .cache()
        // This one caches the whole src from scratch
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS).cache();

        src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(3000);
    }
}
