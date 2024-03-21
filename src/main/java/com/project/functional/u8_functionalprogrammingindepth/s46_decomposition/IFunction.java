package com.project.functional.u8_functionalprogrammingindepth.s46_decomposition;

@FunctionalInterface
public interface IFunction <T, R> {
    R apply(T t);

    // Desired: Square - Double
    // Prev: Square - Integer
    // Next: Integer - Double

    default <V> IFunction<V, R> compose (IFunction<V, T> prev) {
        return (V v) -> {
            T t = prev.apply(v);
            return this.apply(t);
        };
    }

}
