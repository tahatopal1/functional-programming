package com.project.functional.u14_collectionfunctional.s100_list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight", 2015, "Hollywood"),
                new Movie("Avengers: Infinity War", 2018, "Hollywood"),
                new Movie("Inception", 2015, "Hollywood"),
                new Movie("Forest Gump", 2015, "Hollywood"),
                new Movie("3 Idiots", 2015, "Bollywood"),
                new Movie("Beauty and the Beast", 2015, "Hollywood"),
                new Movie("Slumdog Millionaire", 2015, "Bollywood")
        );

        // Traversal
        movies.forEach(System.out::println);
        System.out.println("----------");

        // Sorting
        // movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
        movies.sort((o1, o2) -> Integer.compare(o2.getReleaseYear(), o1.getReleaseYear()));
        movies.sort(Comparator.comparing(Movie::getReleaseYear, Comparator.reverseOrder()));
        movies.forEach(System.out::println);
        System.out.println("----------");

        // Mapping
        movies.stream()
                .map(Movie::getName)
                .forEach(System.out::println);
        System.out.println("----------");

        // Filtering
        movies.stream()
                .filter(movie -> movie.getIndustry().equalsIgnoreCase("Bollywood"))
                .forEach(System.out::println);
        System.out.println("----------");

        // Reduce
        movies.stream()
                .map(Movie::getName)
                .reduce((m1, m2) -> m1 + " | " + m2)
                .ifPresent(System.out::println);

    }
}
