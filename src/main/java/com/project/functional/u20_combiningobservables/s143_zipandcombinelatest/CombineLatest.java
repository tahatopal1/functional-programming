package com.project.functional.u20_combiningobservables.s143_zipandcombinelatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatest {

    // Emitted item of one source gets paired with the latest emitted item of the others
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS).take(10);

        Observable.combineLatest(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);

        Thread.sleep(20000);
    }
}
