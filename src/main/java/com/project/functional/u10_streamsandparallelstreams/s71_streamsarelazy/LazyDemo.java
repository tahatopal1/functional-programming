package com.project.functional.u10_streamsandparallelstreams.s71_streamsarelazy;

import com.project.functional.u10_streamsandparallelstreams.s64_streamsintro.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LazyDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.4));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.1));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.6));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 3.2));

        Stream<Book> stream = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .peek(System.out::println)
                .filter(book -> book.getRating() > 3);

        System.out.println("Filtering Done!"); // This prints first as the Streams are lazy
        collect(stream);

    }

    private static void collect(Stream<Book> stream) {
        List<Book> popularHorrorBooks = stream.toList();
        System.out.println("Collection Done!");
        popularHorrorBooks.forEach(System.out::println);
    }
}
