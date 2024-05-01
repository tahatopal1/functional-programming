package com.project.functional.u22_subjectandreplayandcache.s157_subjectimplementations;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectDemo {

    // Emits only the last value observed to all subsequent completion,
    // ... and only if it has completed.

    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));
        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete(); // It gets emitted if only this is called.
    }
}
