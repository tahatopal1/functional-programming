package com.project.functional.u10_streamsandparallelstreams.s64_streamsintro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsAreNotContainers {

    // Streams are not containers

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.4));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.1));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.6));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 3.2));

        List<Book> popularHorrorBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .toList();

        popularHorrorBooks.forEach(System.out::println);

        List<Book> popularRomanticBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Romance"))
                .filter(book -> book.getRating() > 3)
                .toList();

        popularRomanticBooks.forEach(System.out::println);

        // What if we try to generate the Stream first,
        // ... then use it for both the cases???

        try {
            Stream<Book> nStream = books.stream();

            List<Book> nPopularBookList = nStream
                    .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                    .filter(book -> book.getRating() > 3)
                    .toList();

            nStream
                    .filter(book -> book.getGenre().equalsIgnoreCase("Romance"))
                    .filter(book -> book.getRating() > 3)
                    .toList();


        } catch (Exception e) {

            // Once you operate on a Stream, it becomes empty.
            // Stream is immutable and you can use it only once.

            // We neither can add anything into the stream
            // ... nor we can remove anything from it

            // The most we can do is to read elements from it for once and
            // ... return a new String

            // It's not something like a collection but a fancy iterator

            System.out.println("We cannot use the stream for both the cases: " + e.getMessage());
        }

    }
}
