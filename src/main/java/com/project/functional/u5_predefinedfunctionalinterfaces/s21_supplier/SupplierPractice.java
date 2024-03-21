package com.project.functional.u5_predefinedfunctionalinterfaces.s21_supplier;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> new String("New String");
        String s = stringSupplier.get();
        System.out.println(s);

        Supplier<Double> doubleSupplier = () -> Math.random();
        Double randomNumber = doubleSupplier.get();
        System.out.println(randomNumber);
    }
}
