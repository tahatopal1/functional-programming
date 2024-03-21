package com.project.functional.u15_datastructuresfunctional.s106_list;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ListFun<Integer> list = ListFun.list(3, 6, 9);
        list.forEach(System.out::println);
        System.out.println();

        ListFun<Integer> newList = list.add(56);
        newList.forEach(System.out::println);
        System.out.println();

        newList = newList.removeByObject(9);
        newList.forEach(System.out::println);
        System.out.println();

        newList = newList.reverseList();
        newList.forEach(System.out::println);
        System.out.println();

        ListFun<Integer> list1 = ListFun.list(3, 6, 9, 8);
        ListFun<Integer> list2 = ListFun.list(35,78,90);

        ListFun.concat(list1, list2).forEach(System.out::println);
        System.out.println();

        List<Integer> l = List.of(2, 5, 8, 6);
        list1.addAll(l).forEach(System.out::println);

    }
}
