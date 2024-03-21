package com.project.functional.u4_practicelambda.s13_withparamandreturn;

public class LambdaPractice3 {
    public static void main(String[] args) {
        LengthOfString len = str -> str.length();
        int productivity = len.length("Productivity");
        System.out.println(productivity);
    }
}
