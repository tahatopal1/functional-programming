package com.project.functional.u10_streamsandparallelstreams.s76_streamofandflatmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("Hello", "There!");
        Stream<String> b = Stream.of("Learning", "Java?");

        Stream<Stream<String>> streamOfStream = Stream.of(a, b);

        // Flatten and print every item
        streamOfStream.flatMap(Function.identity()).forEach(System.out::println);

        System.out.println("*******************");

        // Second example
        Student john = new Student("John", List.of("Geography", "Maths", "Biology"));
        Student jack = new Student("Jack", List.of("Physics", "History", "Literature"));

        // Flatten and print every lesson
        Stream.of(john, jack)
                .flatMap(student -> student.getLessons().stream())
                .forEach(System.out::println);

    }
}

@AllArgsConstructor
@Getter
@Setter
class Student {
    String name;
    List<String> lessons;
}
