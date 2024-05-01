package com.project.functional.u22_subjectandreplayandcache.s157_subjectimplementations;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UnicastSubjectDemo {

    // Buffers all items until a single subscriber is present and replays all
    // ... buffered items to that subscriber only, supporting only one subscriber
    // ... over its lifetime.

    public static void main(String[] args) throws InterruptedException {
        UnicastSubject<Long> subject = UnicastSubject.create();
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        Thread.sleep(2000);
    }

}
