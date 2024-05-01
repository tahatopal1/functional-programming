package com.project.functional.u23_bufferingthrottlingswitching.s160_bufferandwindow;

import io.reactivex.rxjava3.core.Observable;

public class BufferDemo1 {

    // We create buffer to stabilize the emissions.
    // Buffer returns a collection with the determined count as length.
    // In example below, we're going to have buffers
    // ... as collections consist of 4 items (at most)

    public static void main(String[] args) {
        Observable.range(1, 30)
                .buffer(4)
                .subscribe(System.out::println);
    }
}
