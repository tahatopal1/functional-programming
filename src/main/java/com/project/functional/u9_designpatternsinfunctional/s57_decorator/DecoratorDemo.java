package com.project.functional.u9_designpatternsinfunctional.s57_decorator;

public class DecoratorDemo {

    // Decorator design pattern is used to modify functionality
    // ... of object at runtime without affecting the other instances
    // ... of the same class.

    public static void main(String[] args) {
        Burger burger = new BurgerShop(Burger::addVeggies)
                .use(new BurgerShop(Burger::addCheese).use(new Burger()));
        System.out.println(burger);;
    }
}
