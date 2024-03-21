package com.project.functional.u12_collectors.s92_cascadingcollectors;

import com.project.functional.u12_collectors.s88_collectors1.Employee;
import com.project.functional.u12_collectors.s88_collectors1.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/tahatopal/IdeaProjects/Java Functional Programming/src/main/java/com/project/functional/u12_collectors/s88_collectors1/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)){
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordsSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordsSpliterator);
            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeesList = employees.toList();

            // Counting by designation
            System.out.println("***** COUNT BY DESIGNATION *****");
            Map<String, Long> countByDesignation = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting()));
            countByDesignation.entrySet().forEach(System.out::println);

            // Fund by designation
            System.out.println("***** FUND BY DESIGNATION *****");
            Map<String, Double> fundByDesignation = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.summingDouble(Employee::getSalary)));
            fundByDesignation.entrySet().forEach(System.out::println);

            // Max salary employees on each designation
            System.out.println("***** MAX SALARY EMPLOYEES OF EACH DESIGNATION *****");
            Map<String, Optional<Employee>> maxSalaryEmployees = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation,
                            Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

            maxSalaryEmployees.values()
                    .stream()
                    .flatMap(Optional::stream)
                    .forEach(System.out::println);

            // Max salaries on each designation
            System.out.println("***** MAX SALARIES OF EACH DESIGNATION *****");
            Map<String, Optional<Double>> maxSalaries = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation,
                            Collectors.mapping(Employee::getSalary, Collectors.maxBy(Comparator.comparing(Function.identity())))));

            maxSalaries.entrySet().forEach(System.out::println);

        }
    }
}
