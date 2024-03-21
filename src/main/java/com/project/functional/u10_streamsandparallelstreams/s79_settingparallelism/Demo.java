package com.project.functional.u10_streamsandparallelstreams.s79_settingparallelism;

import com.project.functional.u10_streamsandparallelstreams.s77_parallelstreams.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        // If don't set property, it'll be default amount of available processor minus 1
        // ... as it needs a thread for main method.
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        // We can even create our custom Fork Join Pool
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        List<Employee> list = new ArrayList<>();

        for (long i = 0; i < 9999999; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Jack", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Ed", 8000));
            list.add(new Employee("Tim", 50000));
        }

        Long count = forkJoinPool.submit(() -> list.parallelStream()
                        .filter(e -> e.getSalary() > 1000)
                        .count())
                .get();

        // Computational Intensive: Number of threads <= number of cores
        // IO Intensive: Number of threads > number of cores (as threads will be blocked for plenty of time)

    }
}
