package com.project.functional.u5_predefinedfunctionalinterfaces.s18_genericfunctionalinterfaces;

public class FunctionalGenericsDemo {
    public static void main(String[] args) {
        FunctionalGenerics<String, String> fun1 = s -> s.substring(2,5);
        String substr = fun1.execute("Productivity");
        System.out.println(substr);

        FunctionalGenerics<String, Integer> fun2 = s -> s.length();
        Integer len = fun2.execute("Productivity");
        System.out.println(len);

        // By using generics with functional interface, we no longer need to create
        // ... functional Interfaces for every type

    }
}
