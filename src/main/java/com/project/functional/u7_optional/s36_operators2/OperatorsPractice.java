package com.project.functional.u7_optional.s36_operators2;

import java.util.Optional;

public class OperatorsPractice {
    public static void main(String[] args) {

        // If Present
        // This processes the value if it's present and returns nothing
        // Takes a Consumer as a parameter
        System.out.println("*** ifPresent() test ***");
        Optional<String> optional = Optional.of("value");
        Optional<String> emptyOptional = Optional.empty();

        optional.ifPresent(System.out::println); // This will print
        emptyOptional.ifPresent(System.out::println); // This will not
        System.out.println();


        // If Present or Else
        // If user wants to run something even though value is empty
        // ... ifPresentOrElse is a good choice.
        // Takes a Consumer and a Runnable as parameters
        System.out.println("*** ifPresentOrElse() test ***");

        // This will print the value
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));

        // This will print the message
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));
        System.out.println();

        // Stream
        System.out.println("stream() test");
        optional.stream().forEach(System.out::println);
        System.out.println();

        // Or
        // Just like orElse() or orElseGet()
        // It takes a Supplier<Optional> instead and
        // ... returns an Optional if the current one is empty
        System.out.println("*** or() test ***");

        // This one will print 'value'
        optional.or(() -> Optional.of("New Value")).ifPresent(System.out::println);

        // This one will print 'New Value'
        emptyOptional.or(() -> Optional.of("New Value")).ifPresent(System.out::println);
        System.out.println();

        // Equals
        // Either both are empty or the values are equal
        // ... via .equals() method
        System.out.println("*** equals() test ***");
        boolean isEqual = optional.equals(Optional.of("value"));
        System.out.println("is equal? -> " + isEqual);
        System.out.println();

        // Hashcode
        // If Optional is not empty, return a value; otherwise it returns '0'
        System.out.println("*** equals() test ***");
        int nonEmptyHashcode = optional.hashCode();
        int emptyHashcode = emptyOptional.hashCode();

        System.out.println("Non-empty Hashcode: " + nonEmptyHashcode);
        System.out.println("Empty Hashcode: " + emptyHashcode);

    }
}
