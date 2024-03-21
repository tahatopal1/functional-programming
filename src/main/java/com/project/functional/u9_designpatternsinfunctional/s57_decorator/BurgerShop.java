package com.project.functional.u9_designpatternsinfunctional.s57_decorator;

import java.util.function.Function;

public class BurgerShop {

    Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration) {
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
        System.out.println("Base burger: " + baseBurger);
        return decoration.apply(baseBurger);
    }
}
