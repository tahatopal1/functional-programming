package com.project.functional.u23_bufferingthrottlingswitching.s160_bufferandwindow;

import io.reactivex.rxjava3.core.Observable;

public class BufferDemo3 {

    // [1, 2, 3, 4]      --> Skips 4 to 8
    // [8, 9, 10, 11]    --> Skips 11 to 15
    // [15, 16, 17, 18]  --> Skips 18 to 22
    // [22, 23, 24, 25]  --> Skips 25 to 29
    // [29, 30]


    public static void main(String[] args) {
        Observable.range(1, 30)
                .buffer(4, 7)
                .subscribe(System.out::println);
    }
}
