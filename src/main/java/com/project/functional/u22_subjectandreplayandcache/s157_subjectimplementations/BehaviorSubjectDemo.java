package com.project.functional.u22_subjectandreplayandcache.s157_subjectimplementations;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class BehaviorSubjectDemo {

    // Emits the most recent item it has observed at time of subscription
    // ... to new subscribers, or an initial value if non has been emitted yet

    public static void main(String[] args) {
        BehaviorSubject<String> subject = BehaviorSubject.create();
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
