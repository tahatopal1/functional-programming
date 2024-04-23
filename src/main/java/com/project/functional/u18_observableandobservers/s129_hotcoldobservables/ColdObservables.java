package com.project.functional.u18_observableandobservers.s129_hotcoldobservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdObservables {

    // It only emits the data if an observer gets subscribed.
    // As if you're replying a list of music.
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> source = Observable.fromIterable(list);
        source.subscribe(System.out::println);

        list = getData(list);
        source.subscribe(System.out::println);

    }

    private static List<Integer> getData(List<Integer> list) {
        list.add(19);
        return list;
    }

}
