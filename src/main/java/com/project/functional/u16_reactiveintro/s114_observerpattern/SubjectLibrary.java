package com.project.functional.u16_reactiveintro.s114_observerpattern;

public interface SubjectLibrary {
    void subscribeObserver(Observer ob);

    void unsubscribeObserver(Observer ob);

    void notifyObserver();

}
