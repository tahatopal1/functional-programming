package com.project.functional.u19_rxoperators.s135_whatareoperators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        Observable.just(60, 57, 89, 90, 23)
                .filter(e -> e > 75)
                .subscribe(System.out::println);

        System.out.println();

        Observable.just(60, 57, 89, 90, 23, 100, 98)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);

    }
}
