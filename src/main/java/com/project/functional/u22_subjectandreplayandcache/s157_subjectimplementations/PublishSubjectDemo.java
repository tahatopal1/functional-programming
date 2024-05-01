package com.project.functional.u22_subjectandreplayandcache.s157_subjectimplementations;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class PublishSubjectDemo {

    // Emits all subsequent items to its subscribers after they have subscribed,
    // ... without retaining any history

    public static void main(String[] args) {

        PublishSubject<String> subject = PublishSubject.create();
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
