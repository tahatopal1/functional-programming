package com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.impl;

import com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.Flooring;

public class WoodenFlooring implements Flooring {
    @Override
    public void installation() {
        System.out.println("The wooden flooring is installed!");
    }
}
