package com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.impl;

import com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.Flooring;

public class CorkFlooring implements Flooring {
    @Override
    public void installation() {
        System.out.println("The cork flooring is installed!");
    }
}
