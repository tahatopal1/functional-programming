package com.project.functional.u22_subjectandreplayandcache.s155_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectDemo2 {
    public static void main(String[] args) throws InterruptedException {

        // In this example, we are emitting on main thread
        // So it only emits from the first source, as it's
        // ... a hot observable by its nature

        Observable<Integer> src1 = Observable.just(5, 10, 15, 20);
        Observable<Integer> src2 = Observable.just(50, 100, 150, 200);

        Subject<Object> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(9000);
    }
}
