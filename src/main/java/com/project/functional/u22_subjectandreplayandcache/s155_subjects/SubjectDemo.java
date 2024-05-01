package com.project.functional.u22_subjectandreplayandcache.s155_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectDemo {
    public static void main(String[] args) throws InterruptedException {

        // In RxJava, a Subject acts as both an Observable and an Observer
        // This dual nature makes Subjects useful as a bridge or a proxy
        // ... in a reactive workflow.

        // We can do many thing with the plain observables that we can
        // ... do by using Subjects. However, we have a bit more manual
        // ... control on the sources with the Subjects.

        // In this example, we are emitting on different threads

        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> src2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        Subject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(9000);
    }
}
