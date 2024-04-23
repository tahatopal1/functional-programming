package com.project.functional.u20_combiningobservables.s141_flatmapandconcatmap;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlatMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // List of user IDs
        Observable<Integer> userIds = Observable.just(1, 2, 3, 4, 5);

        userIds.flatMap(id ->
                getUserDetails(id)
                        .subscribeOn(Schedulers.io()) // Perform each user detail fetch on an IO scheduler thread
        ).subscribe(
                user -> System.out.println("Received user details: " + user),
                Throwable::printStackTrace,
                () -> System.out.println("Completed fetching all user details.")
        );

        // Wait for a moment to ensure all asynchronous operations complete
        Thread.sleep(50000); // This is just to keep the JVM alive to see the results
    }

    // Simulated asynchronous operation to fetch user details
    static Observable<String> getUserDetails(int userId) {
        return Observable.<String>create(emitter -> {
            try {
                // Simulate network delay
                Thread.sleep(((int)(Math.random() * 5) + 1) * 1000 * userId); // Deliberate delay to mimic network latency
                emitter.onNext("User" + userId);
                emitter.onComplete();
            } catch (InterruptedException e) {
                emitter.onError(e);
            }
        });
    }
}
