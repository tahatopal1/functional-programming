package com.project.functional.u23_bufferingthrottlingswitching.s160_bufferandwindow;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;

public class BufferDemo2 {

    // In the following example, we determine the type of collection manually.

    public static void main(String[] args) {
        Observable.range(1, 30)
                .buffer(4, HashSet::new)
                .subscribe(e -> System.out.println("Result: " + (e instanceof HashSet)));
    }
}
