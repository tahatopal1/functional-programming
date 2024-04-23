package com.project.functional.u20_combiningobservables.s144_grouping;

import io.reactivex.rxjava3.core.Observable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Demo {
    public static void main(String[] args) {
        Observable<Employee> source = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(102, "Tom", 94000, 4.7),
                new Employee(103, "Jennifer", 65000, 4.0),
                new Employee(104, "James", 85000, 4.4),
                new Employee(105, "Michael", 50000, 3.6),
                new Employee(106, "Lee", 85000, 4.5),
                new Employee(107, "Lucy", 60000, 4.0),
                new Employee(108, "Emma", 94000, 4.7),
                new Employee(108, "Betty", 75000, 4.3),
                new Employee(108, "Jonathan", 55000, 3.7)
        );

        source.groupBy(Employee::getRate)
                .flatMapSingle(e
                        -> e.toMultimap(key -> e.getKey(), Employee::getName))
                .subscribe(System.out::println);

    }
}

@Getter
@Setter
@AllArgsConstructor
class Employee {
    private int id;
    private String name;
    private long salary;
    private double rate;
}
