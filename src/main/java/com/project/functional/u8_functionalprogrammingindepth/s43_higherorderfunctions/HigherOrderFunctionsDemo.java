package com.project.functional.u8_functionalprogrammingindepth.s43_higherorderfunctions;

public class HigherOrderFunctionsDemo {
    public static void main(String[] args) {
        // Higher order function; takes a function as a parameter
        // ... or returns a function. OR BOTH!!!

        // Gets us a different number every time as .random() is used
        IFactory<Integer> factory = createFactory(() -> Math.random() * 100, Double::intValue);
        Integer created = factory.create();
        System.out.println("Created: " + created);

    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T produced = producer.produce();
            return configurator.configure(produced);
        };
    }

}


