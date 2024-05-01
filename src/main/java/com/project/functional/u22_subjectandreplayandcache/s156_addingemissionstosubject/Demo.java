package com.project.functional.u22_subjectandreplayandcache.s156_addingemissionstosubject;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(System.out::println);

        subject.onNext("Hello");
        subject.onNext("Welcome!");
        subject.onComplete(); // After this call, you won't be able to emit any additional emissions
        subject.onNext("How are you?");


    }
}
