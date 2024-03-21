package com.project.functional.u7_optional.s35_operators1;

import java.util.Optional;

public class OperatorsPractice {
    public static void main(String[] args) {

        Optional<String> optional = Optional.of("Value");
        Optional<String> emptyOptional = Optional.empty();

        // Map

        // This one will return "Replaced"
        String replaced = optional.map(val -> "Replaced").orElse("Empty");

        // This one will return "Empty" as you cannot map an empty value
        String empty = emptyOptional.map(val -> "Replaced").orElse("Empty");

        System.out.println("Non-empty value: " + replaced);
        System.out.println("Empty value: " + empty);

        // Filter
        String filtered = optional
                .filter(val -> val.equalsIgnoreCase("value"))
                .orElse("Empty");

        String falsyFiltered = optional
                .filter(val -> val.equals("value"))
                .orElse("Empty");

        System.out.println("Filtered value: " + filtered);
        System.out.println("Falsy filtered value: " + falsyFiltered);

        // FlatMap
        Optional<String> flatMapped = optional.flatMap(val -> Optional.of("Replaced by FlatMap"));
        System.out.println(flatMapped.get());

    }
}
