package com.project.functional.u19_rxoperators.s136_typesofoperators;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.boot.web.server.Ssl;

import java.util.concurrent.TimeUnit;

public class TransformingOperators {
    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> intObservable = Observable.just(1, 2, 3);
        Observable<Number>  numberObservable = Observable.just(1, 2.5, 3.14);
        Observable<String>  strObservable = Observable.just("Hello", "World", "RxJava");
        Observable<Integer> unsortedObservable = Observable.just(6, 4, 8, 9, 11);

        // Map
        System.out.println("***** MAP *****");
        intObservable.map(num -> num * num).subscribe(System.out::println); // Output: 1, 4, 9

        // Cast
        System.out.println("***** CAST *****");
        numberObservable.cast(Integer.class)
                .subscribe(System.out::println, err -> System.out.println("Error!")); // Output: Error

        // Delay
        System.out.println("***** DELAY *****");
        strObservable.delay(2, TimeUnit.SECONDS)
                .subscribe(System.out::println); // Items will be emitted after 2 seconds delay
        Thread.sleep(4000);


        // Delay Subscription
        System.out.println("***** DELAY SUBSCRIPTION *****");
        strObservable.delaySubscription(2, TimeUnit.SECONDS)
                .subscribe(System.out::println); // Subscription and thus emission will start after 2 seconds
        Thread.sleep(4000);


        // Scan
        System.out.println("***** SCAN *****");
        intObservable.scan(0, (sum, item ) -> sum + item)
                .subscribe(System.out::println); // Output: 1, 3, 6

        // Sorted
        System.out.println("***** SORTED *****");
        unsortedObservable.sorted().subscribe(System.out::println); // Output: 4, 6, 8, 9, 11

        // Repeat
        System.out.println("***** REPEAT *****");
        Observable.just("Repeat").repeat(3)
                .subscribe(System.out::println); // Output: Repeat, Repeat, Repeat


    }
}
