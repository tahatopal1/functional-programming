package com.project.functional.u23_bufferingthrottlingswitching.s162_switchMap;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SwitchMapDemo {

    // Similar to flatmap
    // It only subscribes to the last emitted observable and dispose the previous ones.

    public static void main(String[] args) throws InterruptedException {

        Observable<String> source = Observable.just("John", "Lily", "Emma", "Jack", "Rob")
                .concatMap(s -> Observable.just(s)
                        .delay(ThreadLocalRandom.current().nextInt(5000), TimeUnit.MILLISECONDS));

        Observable.interval(2, TimeUnit.SECONDS)
                .switchMap(s -> source.doOnDispose(() -> System.out.println("Disposing and starting again!")))
                .subscribe(System.out::println);

        Thread.sleep(100000);
    }
}
