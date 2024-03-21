package com.project.functional.u10_streamsandparallelstreams.s72_numericstreams;

import com.project.functional.u10_streamsandparallelstreams.s64_streamsintro.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.4));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.1));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.6));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 3.2));

        OptionalDouble average = books.stream().mapToDouble(Book::getRating).average();
        System.out.println(average.getAsDouble());

        // map: Objects
        // mapToDouble: primitive double
        // mapToInt: primitive integer
        // mapToLong: primitive long

        // By using IntStream, LongStream and DoubleStream, we avoid cost of
        // ... boxing and unboxing
        IntStream intStream = IntStream.of(1, 3, 5, 8);
        DoubleStream doubleStream = DoubleStream.of(1, 3, 5, 8);
        LongStream longStream = LongStream.of(1L, 3L, 5L, 8L);

        Stream<Integer> boxedIntegerStream = intStream.boxed();
        Stream<Double> boxedDoubleStream = doubleStream.mapToObj(t -> t);

    }
}
