package com.project.functional.u4_practicelambda.s11_noparamnoreturn;

public class LambdaPractice1 {
    public static void main(String[] args) {
        Name name = () -> System.out.println("John");
        name.myName();
    }
}
