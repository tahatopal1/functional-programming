package com.project.functional.u9_designpatternsinfunctional.s60_builder;

public class BuilderDemo {

    // Builder pattern is all about providing flexibility in
    // ... object creation. The intent of the builder pattern
    // ... is to isolate the construction of a complex object
    // ... from its representation.

    public static void main(String[] args) {
        MobileBuilder mobileBuilder = new MobileBuilder();
        Mobile mobile = mobileBuilder.with(builder -> {
            builder.ram = 4;
            builder.storage = 4000;
            builder.processor = "A12 Bionic";
        }).createMobile();
        System.out.println(mobile);

    }
}
