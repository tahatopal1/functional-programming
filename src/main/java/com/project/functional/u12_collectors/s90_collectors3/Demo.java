package com.project.functional.u12_collectors.s90_collectors3;

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
        Path path = Paths.get("/Users/tahatopal/IdeaProjects/functional-programming/src/main/java/com/project/functional/u12_collectors/s88_collectors1/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)){
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordsSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordsSpliterator);
            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeesList = employees.toList();

            // Extracting employee names as String, with comma between them
            System.out.println("***** JOINING *****");
            String employeeNames = employeesList.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(","));
            System.out.println(employeeNames);

            // Counting the salaries
            System.out.println("***** COUNTING *****");
            long count = employeesList.stream().map(Employee::getSalary).count();
            System.out.println("Count: " + count);

        }
    }
}
