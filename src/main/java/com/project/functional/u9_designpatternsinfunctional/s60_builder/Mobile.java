package com.project.functional.u9_designpatternsinfunctional.s60_builder;

import lombok.Builder;
import lombok.Data;
@Data
public class Mobile {

    final int ram;
    final int storage;
    final int camera;
    final String processor;
    final double screenSize;

    public Mobile(MobileBuilder mobileBuilder) {
        this.ram = mobileBuilder.ram;
        this.storage = mobileBuilder.storage;
        this.camera = mobileBuilder.camera;
        this.processor = mobileBuilder.processor;
        this.screenSize = mobileBuilder.screenSize;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", camera=" + camera +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
