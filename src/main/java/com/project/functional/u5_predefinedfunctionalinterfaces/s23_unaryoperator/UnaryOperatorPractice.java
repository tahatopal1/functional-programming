package com.project.functional.u5_predefinedfunctionalinterfaces.s23_unaryoperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorPractice {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        UnaryOperator<Integer> operator = i -> i * 100;

        List<Integer> multipliedBy100 = mapper(list, operator);
        System.out.println(multipliedBy100);
    }

    private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();
        for (T t: list) {
            T applied = operator.apply(t);
            newList.add(applied);
        }
        return newList;
    }

}
