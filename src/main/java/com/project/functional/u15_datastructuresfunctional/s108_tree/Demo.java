package com.project.functional.u15_datastructuresfunctional.s108_tree;

public class Demo {
    public static void main(String[] args) {
        TreeFun<Integer> tree = TreeFun.tree(50, 30, 15, 45, 10, 19, 32, 48, 90, 70, 95, 60, 80, 91, 96);
        tree = tree.remove(90);
        System.out.println(tree);

        System.out.println(tree.isMember(10));
        System.out.println(tree.max());
    }
}
