package com.project.functional.u18_observableandobservers.s132_dispose;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class ComposingDisposables {

    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable1 = source.subscribe(e -> System.out.println("Observer 1:" + e)); // Five emissions
        Disposable disposable2 = source.subscribe(e -> System.out.println("Observer 2:" + e)); // Five emissions
        Disposable disposable3 = source.subscribe(e -> System.out.println("Observer 3:" + e)); // Ten emissions

        Thread.sleep(5000);

        disp.addAll(disposable1, disposable2);
        disp.dispose();

        Thread.sleep(5000);


    }
}
