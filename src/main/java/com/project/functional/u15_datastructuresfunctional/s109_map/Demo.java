package com.project.functional.u15_datastructuresfunctional.s109_map;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        MapFun<Integer, String> students = new MapFun<>(5);
        students.put(1, "Nikhil");
        students.put(15, "Sourab");
        students.put(20, "Alex");
        students.put(25, "Tim");
        students.display();

        System.out.println("--------------");

        students.remove(20);
        students.display();
    }
}
