package com.project.functional.u22_subjectandreplayandcache.s156_addingemissionstosubject;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Demo2 {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        // This is pretty important as subject is not a thread-safe asset by default
        // By serializing it, we prevent concurrent access on the resource
        // However, it comes with a performance overhead
        Subject<String> serialized = subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e -> System.out.println("Observer 2: " + e));

        serialized.onNext("Hello");
        serialized.onNext("World");
        serialized.onComplete();
        serialized.onNext("Hello again");
    }
}
