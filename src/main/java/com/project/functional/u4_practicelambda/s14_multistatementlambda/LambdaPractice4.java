package com.project.functional.u4_practicelambda.s14_multistatementlambda;

import com.project.functional.u4_practicelambda.s13_withparamandreturn.LengthOfString;

public class LambdaPractice4 {
    public static void main(String[] args) {
        LengthOfString len = str -> {
            int length = str.length();
            System.out.println("The length of the String is: " + length);
            return length;
        };
        int productivity = len.length("Productivity");
        System.out.println(productivity);
    }
}
