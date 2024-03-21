package com.project.functional.u10_streamsandparallelstreams.s64_streamsintro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntroduction {

    // Stream pipelines consist of three part
    // 1 - Source
    // 2 - Zero or more intermediate operations
    // 3 - Terminal operation

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        List<Book> popularHorrorBooks = new ArrayList<>();

        for (Book book: books) {
            if (book.getGenre().equalsIgnoreCase("Horror") && book.getRating() > 3) {
                popularHorrorBooks.add(book);
            }
        }

        // After Java 8
        // Stream pipeline
        List<Book> collected = books.parallelStream() // Source
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror")) // Intermediate Op
                .filter(book -> book.getRating() > 3) // Intermediate Op
                .toList(); // Terminal Op

        // Observing the stream

        // Step 1 / Source
        Stream<Book> stream = books.stream();

        // Step 2 / Intermediate Op
        Stream<Book> horror = stream.filter(book -> book.getGenre().equalsIgnoreCase("Horror"));

        // Step 3 / Intermediate Op
        Stream<Book> pHorror = horror.filter(book -> book.getRating() > 3);

        // Step 4 / Terminal Op
        List<Book> bookList = pHorror.toList();

    }
}
