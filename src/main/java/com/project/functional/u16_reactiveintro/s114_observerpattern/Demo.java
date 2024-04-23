package com.project.functional.u16_reactiveintro.s114_observerpattern;

import com.project.functional.u16_reactiveintro.s114_observerpattern.impl.Book;
import com.project.functional.u16_reactiveintro.s114_observerpattern.impl.EndUser;

public class Demo {
    public static void main(String[] args) {
        Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");
        EndUser user1 = new EndUser("Bob", book);
        EndUser user2 = new EndUser("Rob", book);

        System.out.println(book.getInStock());

        book.setInStock("In Stock");

    }
}
