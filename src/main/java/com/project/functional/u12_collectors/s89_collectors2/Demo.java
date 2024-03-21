package com.project.functional.u12_collectors.s89_collectors2;

import com.project.functional.u12_collectors.s88_collectors1.Employee;
import com.project.functional.u12_collectors.s88_collectors1.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

            System.out.println("****** Collection(TreeSet) *****"); // Employee class needs to inherits from Comparable
            TreeSet<Employee> employeesSorted = employeesList.stream().collect(Collectors.toCollection(TreeSet::new));
            employeesSorted.forEach(System.out::println);
            // A simpler one
            // TreeSet<Employee> employeesSorted = new TreeSet<>(employeesList);

            // Collecting into map
            System.out.println("****** Map *****");
            Map<Integer, String> getNameById = employeesList.stream().collect(
                    Collectors.toMap(Employee::getId, Employee::getName)
            );
            getNameById.entrySet().forEach(System.out::println);

            System.out.println("****** Partition *****");
            Map<Boolean, List<Employee>> partitionedData = employeesList.stream().collect(
                    Collectors.partitioningBy(employee -> employee.getGender() == 'M')
            ); // This will partition the data into two groups, one meets the requirement, other one doesn't

            System.out.println(partitionedData);

            System.out.println("****** Printing partitions *****");
            List<Employee> males = partitionedData.get(true);
            List<Employee> females = partitionedData.get(false);
            System.out.println(males);
            System.out.println(females);

            System.out.println("****** Grouping *****");
            Map<String, List<Employee>> getByDesignation = employeesList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation)); // Grouping by designation
            System.out.println(getByDesignation);

            System.out.println("****** Printing some groups *****");
            System.out.println(getByDesignation.get("Architect"));
            System.out.println(getByDesignation.get("Lead"));

        }
    }
}
