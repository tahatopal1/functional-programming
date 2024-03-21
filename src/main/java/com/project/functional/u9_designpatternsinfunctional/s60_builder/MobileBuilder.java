package com.project.functional.u9_designpatternsinfunctional.s60_builder;

import java.util.function.Consumer;

public class MobileBuilder {

    int ram;
    int storage;
    int camera;
    String processor;
    double screenSize;

    public MobileBuilder with(Consumer<MobileBuilder> consumer) {
        consumer.accept(this);
        return this;
    }

    public Mobile createMobile() {
        return new Mobile(this);
    }

}
