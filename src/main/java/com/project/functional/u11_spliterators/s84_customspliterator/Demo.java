package com.project.functional.u11_spliterators.s84_customspliterator;

import com.project.functional.u10_streamsandparallelstreams.s64_streamsintro.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Demo {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("/Users/tahatopal/IdeaProjects/Java Functional Programming/src/main/java/com/project/functional/u11_spliterators/s84_customspliterator/Books.txt"))) {
            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> spliterator  = new BookSpliterator(baseSpliterator);
            Stream<Book> stream = StreamSupport.stream(spliterator, false);
            stream.forEach(System.out::println);
        }
    }
}
