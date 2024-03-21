package com.project.functional.u9_designpatternsinfunctional.s58_fluentinterfaces;

public class FluentInterfaceDemo {

    // A fluent interface provides an easy-readable, flowing interface
    // ... that often mimics a domain specific language. Using this pattern
    // ... results in code that can be read nearly as human language.

    public static void main(String[] args) {

        // Not fluent
        Order myOrder = new Order();
        myOrder.add("Shoes");
        myOrder.add("Headphones");
        myOrder.deliverAt("Street no 45, New York");
        myOrder.place();

        System.out.println("-------------------");

        // Fluent by chaining
        new Order()
                .addFluently("Phone")
                .addFluently("Scarf")
                .deliverAtFluently("Street no 23, Los Angeles")
                .place();

        System.out.println("-------------------");

        // Even more fluent
        Order.placeFluently(order ->
                order.addFluently("Tablet")
                        .addFluently("Mouse")
                        .deliverAtFluently("Street no 86, Seattle"));
    }
}
