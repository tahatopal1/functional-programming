package com.project.functional.u10_streamsandparallelstreams.s77_parallelstreams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        // Parallelism is for speed. Most of the computers
        // ... comes with multicore processors so our programs
        // ... can be designed in a way so that they can take
        // ... advantage of multicore processing

        // However, if we are aggregating some data we cannot take
        // advantage of parallel processing.

        // For utilizing the parallel streams, the stream should be:
        // Stateless
        // Non-interfering: Data source should not get affected during processing
        // Associative: Operation result should not get affected by order of the data
        // ... under processing

        List<Employee> list = new ArrayList<>();
        long startTime;
        long endTime;

        for (long i = 0; i < 9999999; i++) {
            list.add(new Employee("John", 20000));
            list.add(new Employee("Jack", 3000));
            list.add(new Employee("Tom", 15000));
            list.add(new Employee("Ed", 8000));
            list.add(new Employee("Tim", 50000));
        }

        startTime = System.currentTimeMillis();
        System.out.println("Performing sequentially: " + list.stream().filter(s -> s.getSalary() > 1000));
        endTime = System.currentTimeMillis();

        System.out.println("Time taken with sequential: " + (endTime - startTime));

        System.out.println("**********************");

        startTime = System.currentTimeMillis();
        System.out.println("Performing parallel: " + list.parallelStream().filter(s -> s.getSalary() > 1000));
        endTime = System.currentTimeMillis();

        System.out.println("Time taken with parallel: " + (endTime - startTime));

    }
}

