package com.project.functional.u7_optional.s33_introducingoptional;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        String val = "A string";
        Optional<String> optional = Optional.of(val);

        // Empty
        Optional<Integer> emptyOptional = Optional.empty();

        // Nullable
        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> anotherEmptyOptional = Optional.ofNullable(null);

        // Wrapping variables with Optionals creates a new object
        // So we only use it in such situations that we want to
        // ... avoid the NullPointerExceptions since it costs performance
    }
}
