package com.project.functional.u5_predefinedfunctionalinterfaces.s18_genericfunctionalinterfaces;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {
    R execute(T t);
}
