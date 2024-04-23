package com.project.functional.u20_combiningobservables.s140_mergeandconcat;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConcatDemo {
    public static void main(String[] args) throws InterruptedException {

        Observable<String> src1
                = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1: " + e).take(5);

        Observable<String> src2
                = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2: " + e).take(5);

        Observable.concat(src1, src2).subscribe(System.out::println);

        Thread.sleep(11000);

    }
}
