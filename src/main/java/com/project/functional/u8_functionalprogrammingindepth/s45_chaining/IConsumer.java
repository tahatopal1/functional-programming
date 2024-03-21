package com.project.functional.u8_functionalprogrammingindepth.s45_chaining;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t);

    // It has to have a body as Functional Interfaces
    // ... can only have one abstract method.
    default IConsumer<T> thenAcceptNullable(IConsumer<T> next) {
        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }

    default IConsumer<T> thenAccept(IConsumer<T> next) {
        Objects.requireNonNull(next);
        return thenAcceptNullable(next);
    }
}
