package com.project.functional.u9_designpatternsinfunctional.s59_factorymethod;

import com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.impl.ConcreteFlooring;
import com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.impl.CorkFlooring;
import com.project.functional.u9_designpatternsinfunctional.s59_factorymethod.impl.WoodenFlooring;

import java.util.function.Supplier;

public class FlooringFactory {
    public static Flooring getFlooring(int minTemperature, int maxTemperature) {
        Supplier<Flooring> flooring;
        if (minTemperature <= 5 && maxTemperature <= 20) {
            flooring = WoodenFlooring::new;
        } else if (minTemperature <= 5 && maxTemperature >= 45) {
            flooring = CorkFlooring::new;
        } else {
            flooring = ConcreteFlooring::new;
        }
        return flooring.get();
    }
}
