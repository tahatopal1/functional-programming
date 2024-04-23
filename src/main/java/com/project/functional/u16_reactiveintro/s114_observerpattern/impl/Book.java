package com.project.functional.u16_reactiveintro.s114_observerpattern.impl;

import com.project.functional.u16_reactiveintro.s114_observerpattern.Observer;
import com.project.functional.u16_reactiveintro.s114_observerpattern.SubjectLibrary;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Book implements SubjectLibrary {

    private String name;
    private String type;
    private String author;
    private double price;

    @Setter(AccessLevel.NONE)
    private String inStock;
    private List<Observer> observerList = new ArrayList<>();

    public Book(String name, String type, String author, double price, String inStock) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Availability changed from Sold out to Back in stock!");
        notifyObserver();
    }

    @Override
    public void subscribeObserver(Observer ob) {
        observerList.add(ob);
    }

    @Override
    public void unsubscribeObserver(Observer ob) {
        observerList.remove(ob);
    }

    @Override
    public void notifyObserver() {
        System.out.println("Book name: " + this.name +
                ", Book type: " + this.type +
                ", Price: " + this.price +
                ", Author: " + this.author +
                ", is now " + this.inStock + ". So, please notify all users.");

        for (Observer o: observerList) {
            o.update(this.inStock);
        }
    }
}
