package com.project.functional.u9_designpatternsinfunctional.s58_fluentinterfaces;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private List<String> cart = new ArrayList<>();
    private String address = "";

    public void add(String item) {
        cart.add(item);
        System.out.println(item + " added to the cart.");
    }

    public Order addFluently(String item) {
        cart.add(item);
        System.out.println(item + " added to the cart.");
        return new Order(this.cart, this.address);
    }

    public void deliverAt(String location) {
        this.address = location;
        System.out.println("The delivery address set: '" + location + "'");
    }

    public Order deliverAtFluently(String location) {
        this.address = location;
        System.out.println("The delivery address set: '" + location + "'");
        return new Order(this.cart, this.address);
    }

    public void place() {
        System.out.println("Order placed!");
        System.out.println(this.cart.size() + " items ordered and will be delivered at '"
            + this.address + "'");
    }

    public static void placeFluently(Function<Order, Order> function) {
        Order order = new Order();
        order = function.apply(order);
        System.out.println("Order placed!");
        System.out.println(order.cart.size() + " items ordered and will be delivered at '"
                + order.address + "'");
    }

}
