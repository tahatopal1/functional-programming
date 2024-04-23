package com.project.functional.u18_observableandobservers.s128_observer;

import io.reactivex.rxjava3.core.Observable;

public class Demo {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("Orange", "Black", "Red");

        // onNext, onError and onComplete
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));
        System.out.println();

        // onNext, onError
        source.subscribe(System.out::println, Throwable::printStackTrace);
        System.out.println();

        // onNext
        source.subscribe(System.out::println);
    }
}
