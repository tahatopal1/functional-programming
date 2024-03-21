package com.project.functional.u5_predefinedfunctionalinterfaces.s25_binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorPractice {
    public static void main(String[] args) {
        BinaryOperator<String> operator = (a, b) -> a + "." + b;
        String applied = operator.apply("google", "com");
        System.out.println(applied);
    }
}
