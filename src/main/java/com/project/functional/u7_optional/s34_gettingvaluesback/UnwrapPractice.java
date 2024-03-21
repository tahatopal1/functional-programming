package com.project.functional.u7_optional.s34_gettingvaluesback;

import java.util.Optional;

public class UnwrapPractice {
    public static void main(String[] args) {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        // get
        Integer integerVal = optional.get();
        System.out.println(integerVal);

        // Risky deal | .get() method on empty optional
        Optional<Integer> emptyOptional = Optional.empty();

        try {
            emptyOptional.get();
        } catch (Exception e) {
            System.out.println("This will give error!");
        }

        // isPresent
        // We can use this one to first validate it's not empty
        int nonEmpty = optional.isPresent() ? optional.get() : 0;
        int empty = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        System.out.println("isPresent: Non-empty value is: " + nonEmpty); // Prints 10
        System.out.println("isPresent: Empty value is: " + empty);
        
        // Other ways for having default values
        
        // orElse
        nonEmpty = optional.orElse(computeExpensiveDefaultValue());
        empty = emptyOptional.orElse(computeExpensiveDefaultValue());
        System.out.println("orElse: Non-empty value is: " + nonEmpty); // Prints 10
        System.out.println("orElse: Empty value is: " + empty);

        // orElseGet
        // This one is more performant because in orElse,
        // ... it has to run the function even the value is not empty
        // orElseGet runs the Supplier function only when the value is empty
        nonEmpty = optional.orElseGet(() -> computeExpensiveDefaultValue());
        empty = emptyOptional.orElseGet(() -> computeExpensiveDefaultValue());
        System.out.println("orElseGet: Non-empty value is: " + nonEmpty); // Prints 10f
        System.out.println("orElseGet: Empty value is: " + empty);

        // orElseThrow
        // This one throws an exception if the optional is empty
        // ... just like .get() method
        // This one has capability to throw a particular type of Exception
        tryIt(optional, "Non-empty");
        tryIt(emptyOptional, "Non-empty");

    }

    private static int computeExpensiveDefaultValue() {
        return (int)(Math.random() * 10);
    }

    private static void tryIt(Optional<Integer> optional, String name) {
        try {
            Integer val = optional.orElseThrow(IllegalArgumentException::new);
            System.out.println(name + " didn't cause an exception and value is: " + val);
        } catch (Exception e) {
            System.out.println(name + " caused an exception");
        }
    }

}
