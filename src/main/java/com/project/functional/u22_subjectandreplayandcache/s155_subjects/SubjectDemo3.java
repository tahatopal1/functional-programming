package com.project.functional.u22_subjectandreplayandcache.s155_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectDemo3 {
    public static void main(String[] args) throws InterruptedException {

        // You can have multiple subscription to the subjects
        // ... with different observers, and you can pass it to
        // ... single observable source. It will provide emissions
        // ... to all those observables.

        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Subject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("The element is: " + e));

        src1.subscribe(subject);

        Thread.sleep(9000);
    }
}
