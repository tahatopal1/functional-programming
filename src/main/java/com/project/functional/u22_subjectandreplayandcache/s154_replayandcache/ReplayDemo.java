package com.project.functional.u22_subjectandreplayandcache.s154_replayandcache;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ReplayDemo {
    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
           .replay(2) // This will cache last 2 emissions. If don't use a parameter, caches the whole source
           .autoConnect();

        src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(3000);
    }
}
