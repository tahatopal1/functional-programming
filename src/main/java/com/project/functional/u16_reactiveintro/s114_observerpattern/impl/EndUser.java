package com.project.functional.u16_reactiveintro.s114_observerpattern.impl;

import com.project.functional.u16_reactiveintro.s114_observerpattern.Observer;
import com.project.functional.u16_reactiveintro.s114_observerpattern.SubjectLibrary;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EndUser implements Observer {

    String name;

    public EndUser(String name, SubjectLibrary subject) {
        this.name = name;
        subject.subscribeObserver(this);
    }

    @Override
    public void update(String avail) {
        System.out.println("Hello " + name + "! We are glad to notify you that your book is now " + avail);
    }
}
