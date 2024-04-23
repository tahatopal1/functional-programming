package com.project.functional.u18_observableandobservers.s132_dispose;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {
    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable1 = source.subscribe(e -> System.out.println("Observer 1:" + e)); // Five emissions
        Disposable disposable2 = source.subscribe(e -> System.out.println("Observer 2:" + e)); // Ten emissions
        Thread.sleep(5000);

        disposable1.dispose();
        Thread.sleep(5000);

    }
}
