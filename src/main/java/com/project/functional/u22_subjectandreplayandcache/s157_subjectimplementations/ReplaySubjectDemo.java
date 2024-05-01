package com.project.functional.u22_subjectandreplayandcache.s157_subjectimplementations;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class ReplaySubjectDemo {

    // Buffers all items it observes and replays them to any subscribers,
    // ... regardless of when they subscribe

    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }
}
